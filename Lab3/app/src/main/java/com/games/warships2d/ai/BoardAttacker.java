package com.games.warships2d.ai;

import android.util.Pair;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class BoardAttacker {
    private static final int n = 10;
    private int x;
    private int y;
    private Stack<Pair<Integer, Integer>> memory;

    public BoardAttacker() {
        memory = new Stack<>();
    }

    public void nextTurn() {
        if(!memory.isEmpty()) {
            x = memory.peek().first;
            y = memory.peek().second;
            memory.pop();
        } else {
            x = ThreadLocalRandom.current().nextInt(0, n);
            y = ThreadLocalRandom.current().nextInt(0, n);
        }
    }

    public void onHit() {
        if(x + 1 < n)
            memory.push(Pair.create(x+1, y));
        if(x - 1 >= 0)
            memory.push(Pair.create(x-1, y));
        if(y + 1 < n)
            memory.push(Pair.create(x, y+1));
        if(y - 1 >= 0)
            memory.push(Pair.create(x, y-1));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
