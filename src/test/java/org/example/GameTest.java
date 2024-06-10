package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GameTest {

    Player player1 = new Player(1, "Petya", 50);
    Player player2 = new Player(2, "Kolya", 65);
    Player player3 = new Player(3, "Lena", 50);
    Player player4 = new Player(4, "Dasha", 43);
    Player player5 = new Player(5, "Sasha", 95);
    Game game = new Game();

    @BeforeEach
    public void setup (){
        game.register(player1);
        game.register(player2);
    }

    @Test
    void shouldRegister() {
        game.register(player3);
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        expected.add(player3);
        ArrayList<Player> actual = game.players;
        Assertions.assertEquals (expected, actual);

    }

    @Test
    void shouldNotRegisterTwice() {
        game.register(player2);
        ArrayList<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player2);
        ArrayList<Player> actual = game.players;
        Assertions.assertEquals (expected, actual);

    }

    @Test
    void roundFirstShouldWin() {
        int actual = game.round("Kolya","Petya");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundSecondShouldWin() {
        int actual = game.round("Petya","Kolya");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundWithNoWinner() {
        game.register(player3);
        int actual = game.round("Petya","Lena");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void roundShouldThrowExceptionForFirstPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vika", "Petya");
        });
    }
    @Test
    void roundShouldThrowExceptionForSecondPlayer() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petya", "Vika");
        });
    }
    @Test
    void roundShouldThrowExceptionForBothPlayers() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dima", "Vika");
        });
    }

}