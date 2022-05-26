import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private static final Color BG_COLOR = new Color(0x0000FF);
    private static final String FONT_NAME = "Text";
    private static final int TILE_SIZE = 54;
    private static final int TILE_MARGIN = 4;

    public static int xCoord;
    public static int yCoord;

    boolean isGameWon = false;
    boolean isGameLost = false;

    private Controller controller;

    public View(Controller controller) {
        setLayout(null);
        setPreferredSize(new Dimension(585, 590));

        setFocusable(true);
        this.controller = controller;
        addMouseListener(controller); //добавляємо слухача (мишка)
    }

    private static int offsetCoors(int arg) { //розрахунок координат кожної Tile (верхнього лівого кута)
        return arg * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(BG_COLOR);
        g.fillRect(0, 0, this.getSize().width, this.getSize().height); // розміщення фону JPanel выдносно до JFrame
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                drawTile(g, controller.getGameTiles()[y][x], x, y); // відмалювання Tile
            }
        }

//        g.setColor(Color.GREEN);
//        g.drawString("X: " + xCoord, 10, 35);
//        g.drawString("Y: " + yCoord, 10, 65);


//        if (isGameWon) {
//            JOptionPane.showMessageDialog(this, "You've won!");
//        } else if (isGameLost) {
//            JOptionPane.showMessageDialog(this, "You've lost :(");
//        }

    }

    public void drawTile(Graphics g2, Tile tile, int x, int y) {
        Graphics2D g = ((Graphics2D) g2);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int value = tile.value;
        int xOffset = offsetCoors(x); //координати кожної Tile (коли відмальовує все поле)
        int yOffset = offsetCoors(y);
        g.setColor(tile.getTileColor()); //колір кожної Tile
        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 8, 8); //відмальвує Tile (без значення)
        tile.xCoord = xOffset;
        tile.yCoord = yOffset;

        g.setColor(tile.getFontColor()); // колір значень (текст)
        final int size = value < 100 ? 28 : value < 1000 ? 32 : 38;
        final Font font = new Font(FONT_NAME, Font.BOLD, size);
        g.setFont(font); //назначення шрифта для Tile

        String s = String.valueOf(value);
        final FontMetrics fm = getFontMetrics(font);

        final int w = fm.stringWidth(s);
        final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

//        if (value != 0) { //відмальовування значень на Tile
//            g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);
//        }
    }
}
