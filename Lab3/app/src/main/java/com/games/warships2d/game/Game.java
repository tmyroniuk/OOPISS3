package com.games.warships2d.game;

import android.graphics.Canvas;

import com.games.warships2d.ai.BoardAttacker;
import com.games.warships2d.ai.BoardFiller;

import java.util.List;

public class Game {
    private Board playerBoard;
    private Board aiBoard;
    private BoardAttacker ai;

    public Game(Board playerBoard) {
        this.playerBoard = playerBoard;
        aiBoard = BoardFiller.fillBoard(10);
        ai = new BoardAttacker();
    }

    public void draw(Canvas canvas, int scale, int x1, int y1, int x2, int y2) {
        playerBoard.draw(canvas, scale, x1, y1, true);
        aiBoard.draw(canvas, scale, x2, y2, false);
    }

    public boolean playerAttack(int x, int y) {
        if(aiBoard.isClear(x, y)) {
            aiBoard.hit(x, y);
            return true;
        }
        return false;
    }

    public void aiAttack() {
        do {
            ai.nextTurn();
        } while (!playerBoard.isClear(ai.getX(), ai.getY()));
        if(playerBoard.hit(ai.getX(), ai.getY())) {
            ai.onHit();
        }
    }

    public boolean isOver() {
        return aiBoard.isLost() || playerBoard.isLost();
    }
}
