import javax.swing.*;
import java.awt.*;

public class MyJFrame extends JFrame {

    public MyJFrame( String name) {
        setTitle(name);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,10);
//        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public Component add(Component comp) {
        return super.add(comp);
    }
}
