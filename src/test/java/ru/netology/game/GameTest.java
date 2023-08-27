package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {

    @Test
    public void testWhenFirstPlayerWin() {
        Player p1 = new Player(1, "Max", 200);
        Player p2 = new Player(2, "Jack", 250);
        Game game = new Game();
        game.register(p1);
        game.register(p2);
        int actual = game.round("Jack", "Max");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player p1 = new Player(1, "Max", 200);
        Player p2 = new Player(2, "Jack", 250);
        Game game = new Game();
        game.register(p1);
        game.register(p2);
        int actual = game.round("Max", "Jack");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenBothPlayersWin() {
        Player p1 = new Player(1, "Max", 200);
        Player p2 = new Player(2, "Jack", 200);
        Game game = new Game();
        game.register(p1);
        game.register(p2);
        int actual = game.round("Max", "Jack");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Player p1 = new Player(1, "Max", 200);
        Player p2 = new Player(2, "Jack", 250);
        Game game = new Game();
        game.register(p1);
        game.register(p2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Jack", "Thomas"));
    }

    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Player p1 = new Player(1, "Max", 200);
        Player p2 = new Player(2, "Jack", 250);
        Game game = new Game();
        game.register(p1);
        game.register(p2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("John", "Max"));
    }

    @Test
    public void testWhenBothPlayersNotRegistered() {
        Player p1 = new Player(1, "Max", 200);
        Player p2 = new Player(1, "Jack", 250);
        Game game = new Game();
        game.register(p1);
        game.register(p2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kamilla", "Andrew"));
    }
}