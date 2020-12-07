package com.games.warships2d;

import com.games.warships2d.game.BattleShip;

import org.junit.Assert;
import org.junit.Test;

public class BattleshipTests {
    @Test
    public void isNearTest() {
        BattleShip ship1 = new BattleShip(4, true);
        BattleShip ship2 = new BattleShip(3, true);
        ship2.setX(1);

        Assert.assertTrue(ship1.isNear(ship2));
        Assert.assertTrue(ship1.isNear(ship1));

        Assert.assertTrue(ship1.isNear(0, 0));
        Assert.assertTrue(ship1.isNear(1, 0));
        Assert.assertFalse(ship1.isNear(2, 0));
        Assert.assertTrue(ship2.isNear(2, 0));
        Assert.assertTrue(ship1.isNear(0, 2));
        Assert.assertTrue(ship2.isNear(0, 2));

        Assert.assertTrue(ship1.isNear(0, 4));
        Assert.assertFalse(ship2.isNear(0, 4));
    }

    @Test
    public void containsTest() {
        BattleShip ship1 = new BattleShip(4, true);
        BattleShip ship2 = new BattleShip(3, false);

        Assert.assertTrue(ship1.contains(0, 0));
        Assert.assertTrue(ship2.contains(0, 0));

        Assert.assertTrue(ship1.contains(0, 1));
        Assert.assertTrue(ship2.contains(1, 0));
        Assert.assertFalse(ship1.contains(1, 0));
        Assert.assertFalse(ship2.contains(0, 1));
    }
}
