package view;

import dataobjects.Executable;
import dataobjects.GameState;
import model.Tile;

public interface UI extends Executable {

    // GENERAL

    void saveGameState(GameState gameState);

    void clearGameState();

    void clearAll();

    void commit();

    // Factory
    void addTileFactory(int factory, Tile tile);

    void removeTileFactory(int factory, Tile tile);

    void clearFactory(int factory);

    // Middle
    void addTileMiddle(Tile tile);

    void removeTileMiddle(Tile tile);

    void clearMiddle();

    // PLAYER SPECIFIC

    void setPlayerName(int PlayerID, String name);

    void setScore(int PlayerID, int Score);

    void setActivePlayerView(int playerID);

    void clearPlayer(int PlayerID);

    // wall
    void addTileWall(int PlayerID, int row, int column, Tile tile);

    void removeTileWall(int PlayerID, int row, int column, Tile tile);

    void clearWall(int PlayerID);

    // paternline
    void addTilePattern(int PlayerID, int row, Tile tile);

    void removeTilePattern(int PlayerID, int row, Tile tile);

    void clearPatternLine(int PlayerID, int row);

    void clearPattern(int PlayerID);

    // floor
    void addTileFloorLine(int PlayerID, Tile tile);

    void removeTileFloorLine(int PlayerID, Tile tile);

    void clearFloorLine(int PlayerID);

}
