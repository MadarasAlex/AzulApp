package unit.view;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.TileColor;
import view.DisplayFactory;

public class DisplayFactoryTest {
    private DisplayFactory displayFactory;

    @BeforeEach
    public void setUp() {
        displayFactory = new DisplayFactory(1);
    }

    @Test
    public void testEmptyFactory() {
        assertEquals("__\n__", displayFactory.toString());
        List<String> result = displayFactory.toStringList();
        assertEquals(2, result.size());
        assertEquals("__", result.get(0));
        assertEquals("__", result.get(1));
    }

    @Test
    public void testsingleTileFactory() {
        displayFactory.addTile(TileColor.RED);
        assertEquals("R_\n__", displayFactory.toString());
        List<String> result = displayFactory.toStringList();
        assertEquals(2, result.size());
        assertEquals("R_", result.get(0));
        assertEquals("__", result.get(1));

    }

    @Test
    public void testMultipleTileFactory() {
        displayFactory.addTile(TileColor.RED);
        displayFactory.addTile(TileColor.CYAN);
        displayFactory.addTile(TileColor.BLUE);

        assertEquals("RB\nC_", displayFactory.toString());
        List<String> result = displayFactory.toStringList();
        assertEquals(2, result.size());
        assertEquals("RB", result.get(0));
        assertEquals("C_", result.get(1));
    }

    @Test
    public void testRemoveTileFactory() {
        displayFactory.addTile(TileColor.RED);
        displayFactory.addTile(TileColor.CYAN);
        displayFactory.addTile(TileColor.RED);
        assertEquals("RR\nC_", displayFactory.toString());
        displayFactory.removeTiles(TileColor.RED);
        assertEquals("C_\n__", displayFactory.toString());
        List<String> result = displayFactory.toStringList();
        assertEquals(2, result.size());
        assertEquals("C_", result.get(0));
        assertEquals("__", result.get(1));
    }

    @Test
    public void testClearFactory() {
        displayFactory.addTile(TileColor.RED);
        displayFactory.clear();
        assertEquals("__\n__", displayFactory.toString());
        List<String> result = displayFactory.toStringList();
        assertEquals(2, result.size());
        assertEquals("__", result.get(0));
        assertEquals("__", result.get(1));
    }
}
