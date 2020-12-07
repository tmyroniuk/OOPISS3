package com.games.warships2d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.games.warships2d.game.BattleShip;
import com.games.warships2d.game.Board;

public class GameView extends View {
    private Board playerBoard;
    private BattleShip currentShip;
    private int ships = 0;
    private static final int n = 10;
    private static final int scale = 80;

    private Activity getActivity() {
        Context context = getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    public GameView(Context context) {
        super(context);
        playerBoard = new Board(n);
        currentShip = new BattleShip(4, true);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint green = new Paint(Color.GREEN);
        green.setAlpha(100);

        playerBoard.draw(canvas, scale, (getWidth() - scale*n) / 2, getHeight()/4, true);
        currentShip.draw(canvas, scale, (getWidth() - scale*n) / 2, getHeight()/4, green);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int i = (int) (y - getHeight()/4) / scale;
        int j = (int) ((x - (getWidth() - scale*n) / 2) / scale);
        if(i >= 0 && j >= 0 && i < n && j < n) {
            currentShip.setX(j);
            currentShip.setY(i);
            if(playerBoard.canAddShip(currentShip)) {
                playerBoard.addShip(currentShip);
                ships++;
                if(ships >= 10) {
                    ((GameActivity) getActivity()).startBattle(playerBoard);
                } else if(ships >= 6) {
                    currentShip = new BattleShip(1, true);
                } else if(ships >= 3) {
                    currentShip = new BattleShip(2, true);
                } else if(ships >= 1) {
                    currentShip = new BattleShip(3, true);
                }
            }
        } else {
            currentShip.setVertical(!currentShip.isVertical());
        }
        invalidate();

        return true;
    }
}
