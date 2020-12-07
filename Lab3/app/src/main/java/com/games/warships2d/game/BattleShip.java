package com.games.warships2d.game;

import android.graphics.Canvas;
import android.graphics.Paint;

public class BattleShip {

    private int length;
    private boolean vertical;
    private int x;
    private int y;

    public BattleShip(int length, boolean vertical) {
        this.length = length;
        this.vertical = vertical;
    }

    public boolean contains(int check_x, int check_y) {
        if(!vertical) {
            return check_y == y && (check_x - x >= 0 && check_x - x < length);
        } else {
            return check_x == x && (check_y - y >= 0 && check_y - y < length);
        }
    }

    public boolean isNear(int check_x, int check_y) {
        if(!vertical) {
            return (check_y - y <= 1 && check_y - y >= -1) && (check_x - x >= -1 && check_x - x <= length);
        } else {
            return (check_x - x <= 1 && check_x - x >= -1) && (check_y - y >= -1 && check_y - y <= length);
        }
    }

    public boolean isNear(BattleShip other) {
        if(!vertical) {
            for(int i = 0; i < length; i++)
                if(other.isNear(x + i, y)) return true;
        } else {
            for(int i = 0; i < length; i++)
                if(other.isNear(x, y + i)) return true;
        }
        return false;
    }

    public void draw(Canvas canvas, int scale, int x, int y, Paint paint) {
        if(vertical) {
            canvas.drawRect(x + getX()*scale, y + getY()*scale, x + (getX() + 1)*scale, y + (getY() + length)*scale, paint);
        } else {
            canvas.drawRect(x + getX()*scale, y + getY()*scale, x + (getX() + length)*scale, y + (getY() + 1)*scale, paint);
        }
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
