import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Solution {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        JFrame frame = new MyJFrame("My Frame");
        JPanel gamePanel = controller.getView();
        gamePanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                View.xCoord = e.getX();
                View.yCoord = e.getY();

                gamePanel.repaint();

            }
        });

        frame.add(gamePanel, BorderLayout.NORTH);

        JPanel menuPanel = controller.getPanel();
        frame.add(menuPanel, BorderLayout.SOUTH);

        frame.pack();

//        JFrame jFrame = new JFrame("Calc");
//        jFrame.setSize(500,523);
//
//        jFrame.add(new MenuPanel(),BorderLayout.SOUTH);
////        jFrame.add(new FieldPanel(),BorderLayout.SOUTH);
//        jFrame.add(new View(controller),BorderLayout.NORTH);
//        jFrame.pack();
//
//        jFrame.setLocationRelativeTo(null);
//        jFrame.setResizable(false);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setVisible(true);


    }

}
