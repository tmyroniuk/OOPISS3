package com.games.warships2d;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.games.warships2d.game.*;

public class BattleView extends View {
    private Game game;
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

    public BattleView(Context context, Board playerBoard) {
        super(context);
        game = new Game(playerBoard);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        game.draw(canvas, scale, 2 * scale, (3 + n) * scale, 2 * scale, scale);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int i = (int) ((y - scale) / scale);
        int j = (int) ((x - 2 * scale) / scale);
        if(i >= 0 && j >= 0 && i < n && j < n) {
            if(game.playerAttack(j, i)) {
                if(game.isOver()) {
                    ((GameActivity) getActivity()).finishBattle();
                }
                game.aiAttack();
                if(game.isOver()) {
                    ((GameActivity) getActivity()).finishBattle();
                }
            }
        }
        invalidate();
        return true;
    }
}
