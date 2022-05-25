import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 10;
    protected int maxTile;
    protected int score;
    private Tile[][] gameTiles;

    private boolean isSaveNeeded = true;
    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;

    public Model() {
        resetGameTiles();
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                if (gameTiles[x][y].isEmpty()) {
                    tiles.add(gameTiles[x][y]);
                }
            }
        }
        return tiles;
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (!tiles.isEmpty()) {
            int random = (int) (tiles.size() * Math.random());
            tiles.get(random).value = Math.random() < 0.9 ? 2 : 4; // тут вибрати правильний колір (значення)
        }
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
//        addTile(); // одну плитку потрібно прибрати
        this.score = 0;
        this.maxTile = 0;
    }

    public boolean canMove() {
        if (!(getEmptyTiles().size() == 0)) return true;

//        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
//            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
//                if (gameTiles[i][j].value == gameTiles[i + 1][j].value ||
//                        gameTiles[i][j].value == gameTiles[i][j + 1].value) {
//                    return true;
//                }
//            }
//        }
        return false;
    }

    public void left() {
//        if (isSaveNeeded) saveState(gameTiles);
        boolean moveFlag = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                moveFlag = true;
            }
        }
        if (moveFlag) {
            addTile();
        }
        isSaveNeeded = true;
    }

    private boolean compressTiles(Tile[] tiles) { //Сжатие плиток
        int insertPosition = 0;
        boolean isChange = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                    isChange = true;
                }
                insertPosition++;
            }
        }
        return isChange;
    }

    private boolean mergeTiles(Tile[] tiles) { //Слияние плиток одного номинала
        boolean isChange = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].isEmpty()) continue;
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value += tiles[i + 1].value;
                tiles[i + 1] = new Tile();
                if (tiles[i].value > maxTile) maxTile = tiles[i].value;
                score += tiles[i].value;
                isChange = true;
            }
        }
        compressTiles(tiles);
        return isChange;
    }

    public void selectTile() {

    }
}
