package com.games.warships2d;

import com.games.warships2d.ai.BoardFiller;
import com.games.warships2d.game.BattleShip;
import com.games.warships2d.game.Board;

import org.junit.Assert;
import org.junit.Test;

public class BoardFillerTest {

    @Test
    public void spacingTest() {
        Board board = BoardFiller.fillBoard(10);
        for(BattleShip ship1: board.getShips()) {
            for(BattleShip ship2: board.getShips()) {
                Assert.assertTrue(ship1 == ship2 || !ship1.isNear(ship2));
            }
        }
    }

}
