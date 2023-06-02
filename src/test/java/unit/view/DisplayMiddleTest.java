package unit.view;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.TileColor;
import view.DisplayMiddle;

public class DisplayMiddleTest {
    private DisplayMiddle displayMiddle;

    @BeforeEach
    public void setUp() {
        displayMiddle = new DisplayMiddle();
    }

    @Test
    public void testEmptyFactory() {
        assertEquals("\n", displayMiddle.toString());
        List<String> result = displayMiddle.toStringList();
        assertEquals(2, result.size());
        assertEquals("", result.get(0));
        assertEquals("", result.get(1));
    }

    @Test
    public void testsingleTileFactory() {
        displayMiddle.addTile(TileColor.RED);
        assertEquals("R\n", displayMiddle.toString());
        List<String> result = displayMiddle.toStringList();
        assertEquals(2, result.size());
        assertEquals("R", result.get(0));
        assertEquals("", result.get(1));
    }

    @Test
    public void testMultipleTileFactory() {
        displayMiddle.addTile(TileColor.RED);
        displayMiddle.addTile(TileColor.CYAN);
        displayMiddle.addTile(TileColor.BLUE);
        displayMiddle.addTile(TileColor.BLUE);
        displayMiddle.addTile(TileColor.CYAN);

        assertEquals("RBC\nCB", displayMiddle.toString());
        List<String> result = displayMiddle.toStringList();
        assertEquals(2, result.size());
        assertEquals("RBC", result.get(0));
        assertEquals("CB", result.get(1));
    }

    @Test
    public void testRemoveTileFactory() {
        displayMiddle.addTile(TileColor.RED);
        displayMiddle.addTile(TileColor.CYAN);
        displayMiddle.addTile(TileColor.BLUE);
        displayMiddle.addTile(TileColor.BLUE);
        displayMiddle.addTile(TileColor.CYAN);

        assertEquals("RBC\nCB", displayMiddle.toString());
        displayMiddle.removeTiles(TileColor.CYAN);
        assertEquals("RB\nB", displayMiddle.toString());

        List<String> result = displayMiddle.toStringList();
        assertEquals(2, result.size());
        assertEquals("RB", result.get(0));
        assertEquals("B", result.get(1));
    }
}
