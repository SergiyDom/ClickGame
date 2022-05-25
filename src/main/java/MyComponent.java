import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {
    public static int xCoord;
    public static int yCoord;

    private Controller controller;


    public MyComponent(Controller controller) {
        setFocusable(true);
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).drawString("Coordinate x: " + xCoord + "  y: " + yCoord, 50, this.getSize().height - 50);

    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(400,200);
//    }
}
