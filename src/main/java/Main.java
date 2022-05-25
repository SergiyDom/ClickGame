import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        JFrame game = new JFrame();
        game.setTitle("_Game_");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        game.setSize(600, 750);
        game.setResizable(false);

        game.add(controller.getView(),BorderLayout.CENTER);// завантажує JPanel - View
        game.pack();
//        game.add(controller.getMyComponent(),BorderLayout.PAGE_END);// завантажує JPanel - View
//        JComponent jComponent = new MyComponent(controller.getView());
//        game.add(jComponent);// завантажує JPanel - MyComponent
//        game.addMouseMotionListener(new MouseAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//                MyComponent.xCoord = e.getX();
//                MyComponent.yCoord = e.getY();
//                jComponent.repaint();
//            }
//        });

        game.setLocationRelativeTo(null);//вставляє нашу JFrame по середині екрану
        game.setVisible(true);

//        controller.getView().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                int r = (int) (Math.random() * 255);
//                int b = (int) (Math.random() * 255);
//                int g = (int) (Math.random() * 255);
////                controller.getView().BG_COLOR = (new Color(r, b, g));
//                controller.getModel().left();
//                controller.getView().repaint();
//            }
//        });
    }
}
