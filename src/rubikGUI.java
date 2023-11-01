import javax.swing.*;
import java.awt.*;

public class rubikGUI {
    private JFrame frame;
    private final JButton[][] buttons = new JButton[2][2];
    private final JLabel[][] clockTime = new JLabel[3][3];
    private final rubikModel rubikmodel;

    public rubikGUI (rubikModel rubikmodel) { this.rubikmodel = rubikmodel; initialiseGUI(); }

    private void initialiseGUI() {
        int x = 0;
        int y = 0;

        buttons[0][0] = new JButton("Button1");
        buttons[0][1] = new JButton("Button2");
        buttons[1][0] = new JButton("Button3");
        buttons[1][1] = new JButton("Button4");

        frame = new JFrame("Rubik Clock Game");
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3,3));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                JPanel panel = new JPanel(new BorderLayout());
                clockTime[i][j] = new JLabel(String.valueOf(rubikmodel.getClock(i, j).getHour()), SwingConstants.CENTER);
                panel.add(clockTime[i][j], BorderLayout.CENTER);

                if ((i == 0 && j == 0) || (i == 0 && j == 2) || (i == 2 && j == 0) || (i == 2 && j == 2)) {
                    panel.add(buttons[x][y], BorderLayout.SOUTH); y++; if (y == 2) { y = 0; x++; }
                } frame.add(panel);
            }
        }
    }

    public JButton getButton(int x, int y) { return buttons[x][y]; }

    public JFrame getFrame() { return frame; }

    public void updateClockTime() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) { clockTime[i][j].setText(String.valueOf(rubikmodel.getClock(i, j).getHour())); }
        }
    }
}