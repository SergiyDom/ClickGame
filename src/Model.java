import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 10;
    protected int compScore;
    protected int score;
    protected int time;
    private Tile[][] gameTiles;
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

//    public void setTime(int time) {
//        this.time = time;
//    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Tile getTile() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value == 2) {
                    return gameTiles[i][j];
                }
            }
        }
        return new Tile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tileList = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    tileList.add(gameTiles[i][j]);
                }
            }
        }
        return tileList;
    }

    public void addTile() {
        System.out.println("add method");
        List<Tile> tileList = getEmptyTiles();
        if (!tileList.isEmpty()) {
            int listSize = tileList.size();
            int random = (int) (listSize * Math.random());
            tileList.get(random).value = 2;
        }
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        this.score = 0;
        this.compScore = 0;
    }

    public void left() {
        score++;
        if (canMove()) {
            addTile();
        }
    }
    public void setCompScore() {
        compScore++;
        if (canMove()) {
            addTile();
        }
    }

    public boolean canMove() {
        return getEmptyTiles().size() != 0;
    }


}
