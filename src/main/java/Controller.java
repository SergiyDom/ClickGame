import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class Controller extends KeyAdapter {
    private static final int WINNING_TILE = 2048;
    private Model model;
    private View view;
    private MyComponent myComponent;

    public Controller(Model model) {
        this.view = new View(this);
        this.myComponent = new MyComponent(this);
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public MyComponent getMyComponent() {
        return myComponent;
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) resetGame();
        if (!model.canMove()) view.isGameLost = true;
        if (!view.isGameLost && !view.isGameWon) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    model.left();
                    break;
            }
        }
        if (model.maxTile == WINNING_TILE) view.isGameWon = true;
        view.repaint();
    }


//    @Override
//    public void mouseClicked(MouseEvent e) {
//        super.mouseClicked(e);
//        model.left();
//        view.repaint();
//        myComponent.repaint();
//    }
}