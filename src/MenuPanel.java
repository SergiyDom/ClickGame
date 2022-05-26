import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    public JLabel yourScore = new JLabel("yourScore:");
    public JLabel computerScore = new JLabel("compScore:");
    public JTextField textField = new JTextField();
    private JLabel setTime = new JLabel("set time (ms):");
    private JButton startButton = new JButton("Start");
    private JButton resetButton = new JButton("Reset");
    private JButton stopButton = new JButton("Stop");

    private Font font = new Font("Arial", Font.BOLD, 20);
    private Controller controller;

    public MenuPanel(Controller controller) {
        setLayout(null);
        setPreferredSize(new Dimension(500, 180));

        this.controller = controller;

        startButton.setBounds(340, 25, 220, 50);
        startButton.setFont(font);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start - Start");
                controller.setTime();
//                controller.getView().repaint();
                startButton.setEnabled(false);
                controller.addFirstTileAndStartGame();
            }
        });
        add(startButton);

        resetButton.setBounds(340, 90, 100, 50);
        resetButton.setFont(font);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reset - Reset");
                startButton.setEnabled(true);
                controller.resetGame();
//                controller.getView().repaint();
            }
        });
        add(resetButton);

        stopButton.setBounds(460, 90, 100, 50);
        stopButton.setFont(font);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Stop - Stop");
                startButton.setEnabled(true);
                controller.stop();
            }
        });
        add(stopButton);

        textField.setBounds(170, 25, 150, 40);
        textField.setEditable(true);
        textField.setFont(font);
        add(textField);

        setTime.setBounds(30, 25, 150, 25);
        setTime.setFont(font);
        add(setTime);

        yourScore.setBounds(30, 75, 300, 25);
        yourScore.setForeground(Color.BLUE);
        yourScore.setFont(font);
        add(yourScore);

        computerScore.setBounds(30, 125, 300, 25);
        computerScore.setFont(font);
        computerScore.setForeground(Color.RED);
        add(computerScore);
    }


}
