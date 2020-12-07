package com.games.warships2d;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.games.warships2d.game.Board;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }

    public void startBattle(Board playerBoard) {
        View battleView = new BattleView(this, playerBoard);
        setContentView(battleView);
    }

    public void finishBattle() {
        setContentView(new GameView(this));
    }

}