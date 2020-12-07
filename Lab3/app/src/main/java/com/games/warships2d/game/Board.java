package com.games.warships2d.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.YuvImage;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int boardState[][];

    private List<BattleShip> ships;

    public Board(int n) {
        ships = new ArrayList<BattleShip>();
        boardState = new int[n][n];
    }

    public boolean isLost() {
        int c1 = 0, c2 = 0;
        for (BattleShip ship : ships)
            c1 += ship.getLength();
        for (int i[] : boardState)
            for (int j : i)
                if (j == 2) c2++;
        return c1 == c2;
    }

    public boolean canAddShip(BattleShip ship) {
        if(ship.isVertical() && ship.getY() + ship.getLength() > boardState.length)
            return false;
        if(!ship.isVertical() && ship.getX() + ship.getLength() > boardState.length)
            return false;
        for (BattleShip i : ships) {
            if (i.isNear(ship)) return false;
        }
        return true;
    }

    public void addShip(BattleShip ship) {
        ships.add(ship);
        System.out.println(ship.getLength());
    }

    public boolean isClear(int x, int y) {
        return boardState[y][x] == 0;
    }

    public boolean hit(int x, int y) {
        for(BattleShip i: ships) {
            if(i.contains(x, y)) {
                boardState[y][x] = 2;
                return true;
            }
        }
        boardState[y][x] = 1;
        return false;
    }

    public void draw(Canvas canvas, int scale, int x, int y, boolean drawShips) {
        Paint yellow = new Paint();
        Paint red = new Paint();
        Paint black = new Paint();
        yellow.setColor(Color.YELLOW);
        yellow.setAlpha(180);
        red.setColor(Color.RED);
        red.setAlpha(180);
        black.setColor(Color.BLACK);

        if(drawShips){
            for(BattleShip i: ships) {
                i.draw(canvas, scale,  x, y, black);
            }
        }

        for(int i = 0; i < boardState.length; i++) {
            for(int j = 0; j < boardState.length; j++) {
                if(boardState[i][j] > 0)
                    canvas.drawRect(x + j*scale, y + i*scale, x + (j+1)*scale, y + (i+1)*scale, boardState[i][j] == 1 ? yellow : red);
            }
            canvas.drawLine(x + i*scale, y, x + i*scale, y + boardState.length*scale, black);
            canvas.drawLine(x, y + i*scale, x + boardState.length*scale, y + i*scale, black);
        }
        canvas.drawLine(x + boardState.length*scale, y, x + boardState.length*scale, y + boardState.length*scale, black);
        canvas.drawLine(x, y + boardState.length*scale, x + boardState.length*scale, y + boardState.length*scale, black);
    }

    public List<BattleShip> getShips() {
        return ships;
    }

}
