package com.games.warships2d.ai;

import com.games.warships2d.game.BattleShip;
import com.games.warships2d.game.Board;

import java.util.concurrent.ThreadLocalRandom;

public class BoardFiller {

    public static Board fillBoard(int n) {
        int ships = 0;
        Board res = new Board(10);
        BattleShip currentShip;

        while(ships < 10) {
            if(ships >= 6) {
                currentShip = new BattleShip(1, true);
            } else if(ships >= 3) {
                currentShip = new BattleShip(2, true);
            } else if(ships >= 1) {
                currentShip = new BattleShip(3, true);
            } else {
                currentShip = new BattleShip(4, true);
            }
            do {
                currentShip.setVertical(ThreadLocalRandom.current().nextInt(0, 2) == 0);
                currentShip.setX(ThreadLocalRandom.current().nextInt(0, n));
                currentShip.setY(ThreadLocalRandom.current().nextInt(0, n));
            } while (!res.canAddShip(currentShip));
            res.addShip(currentShip);
            ships++;
        }
        return res;
    }
}
