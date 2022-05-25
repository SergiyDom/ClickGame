import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter {
    private CheckThread checkThread;
    private Thread thread;
    private Model model;
    private View view;
    private MenuPanel panel;

    public Controller(Model model) {
        this.view = new View(this);
        this.panel = new MenuPanel(this);
        this.model = model;
//        checkThread = new CheckThread(this);

    }

    public void addFirstTileAndStartGame() {
        model.addTile();
        checkThread = new CheckThread(this);
        thread = new Thread(checkThread, "MyTrubleShooterThread");
        thread.start();

        view.repaint();
    }

    public int getTime() {
        return model.time;
    }

    public void setTime() {
        model.time = Integer.parseInt(panel.textField.getText());
    }

    public MenuPanel getPanel() {
        return panel;
    }

    public View getView() {
        return view;
    }

    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public void setCompScore() {
        model.setCompScore();
    }

    public int getCompScore() {
        return model.compScore;
    }

    public void resetGame() {
        checkThread.on = false;
        view.isGameWon = false;
        view.isGameLost = false;
        model.resetGameTiles();
        panel.yourScore.setText("yourScore: ");
        panel.computerScore.setText("compScore: ");
        view.repaint();
    }
    public void stop() {
        checkThread.on = false;

    }

        public Tile getTile() {
        return model.getTile();
    }

    //    public Boolean checkTile(Tile tile) throws ExecutionException, InterruptedException {
//
//        ExecutorService es = Executors.newSingleThreadExecutor();
//        Future<Boolean> result = es.submit(new Callable() {
//
//            @Override
//            public Boolean call() throws Exception {
//                // Ваш исполняемый код в другом потоке...
//                System.out.println("Зайшли в \"ExecutorService\" ");
//                thread = new Thread(new CheckThread(tile, model.time));
//                thread.start();
//                return tile.value == 4;
//            }
//        });
//        return result.get();
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int mouseX = View.xCoord;
        int mouseY = View.yCoord;

        //все що нижче повинно бути в моделі
        Tile tile = getTile(); // отримуэмо Tile жовтого кольору (value = 2)
        int tileX = tile.xCoord;
        int tileY = tile.yCoord;

        if (tile.value == 2) { //ще раз перевіряємо значення
            if ((mouseX >= tileX && mouseX <= tileX + 55) && (mouseY >= tileY && mouseY <= tileY + 55)) {
                System.out.println(" Goal");
//                thread.interrupt();
                tile.value = 6;
                model.left();
                panel.yourScore.setText("yourScore: " + model.score);
            }
        }
        //все що вище повинно бути в моделі

        view.repaint();
        System.out.println("Check Panel");
    }

}
