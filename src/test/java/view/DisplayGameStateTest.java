package view;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DisplayGameStateTest {
    private DisplayGameState gameState;

    @BeforeEach
    public void setUp() {
        gameState = new DisplayGameState();
        gameState.setWallPattern(DisplayWallTest.wallPattern());
        gameState.addPlayer(2, "Bob");
    }

    @Test
    public void testEmptyOutputNoErrors() {
        assertDoesNotThrow(() -> gameState.toString(), "Tee print does not work correctly");
    }

    @Test
    public void testGetPlayer() {
        DisplayPlayer player1 = gameState.getPlayer(2);
        DisplayPlayer player2 = gameState.getPlayer(1);
        assertEquals("Bob", player1.name);
        assertEquals(null, player2);

    }

    @Test
    public void testAddPlayer() {
        DisplayPlayer player1 = gameState.getPlayer(2);
        gameState.addPlayer(1, "Alice");
        DisplayPlayer player2 = gameState.getPlayer(1);
        assertEquals("Bob", player1.name);
        assertEquals("Alice", player2.name);
    }

    @Test
    public void testSetActivePlayer() {
        gameState.setActivePlayer(2);
        assertEquals(0, gameState.activePlayer);
        assertEquals(gameState.getPlayer(2), gameState.players.get(gameState.activePlayer));
    }
}
