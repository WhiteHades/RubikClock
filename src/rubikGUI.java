import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rubikGUI {
    private JFrame frame;
    private JButton[][] buttons = new JButton[2][2];
    private JLabel[][] clockLabels = new JLabel[3][3];
    private rubikModel rubikmodel;

    public rubikGUI (rubikModel rubikmodel) { this.rubikmodel = rubikmodel; initialiseGUI(); }

    private void initialiseGUI() {
        frame = new JFrame("Rubik Clock Game");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                clockLabels[i][j] = new JLabel(String.valueOf(rubikmodel.getClock(i, j).getHour()),
                        SwingConstants.CENTER);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                buttons[i][j] = new JButton("Press");
                frame.add(buttons[i][j]);
            }
        }
        frame.setVisible(true);
    }

    public JButton getButton(int x, int y) { return buttons[x][y]; }

    public JFrame getFrame() { return frame; }

    public void updateClockDisplays() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                clockLabels[i][j].setText(String.valueOf(rubikmodel.getClock(i, j).getHour()));
            }
        }
    }
}
