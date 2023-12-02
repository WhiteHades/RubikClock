import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * The rubikGUI class (GUI). It's associated with rubikModel to indicate that it uses a rubikModel instance.
 */
public class rubikGUI {
    private JFrame frame;
    private final JButton[][] buttons = new JButton[2][2];
    private final JLabel[][] clockTime = new JLabel[3][3];
    private final rubikModel rubikmodel;

    /***
     * The constructor.
     * @param rubikmodel
     */
    public rubikGUI (rubikModel rubikmodel) { this.rubikmodel = rubikmodel; rubikmodel.reset(); initialiseGUI(); }

    /***
     * Initialises the main GUI component of the software. It includes the clock times, the
     * buttons, and the overall frame/layout.
     */
    private void initialiseGUI()  {
        buttons[0][0] = new JButton("Button1");
        buttons[0][1] = new JButton("Button2");
        buttons[1][0] = new JButton("Button3");
        buttons[1][1] = new JButton("Button4");

        frame = new JFrame("Rubik Clock Game");
        frame.setSize(550, 550);
        frame.setLayout(new GridLayout(3,3));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        frame.setLocationRelativeTo(null);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(e -> { rubikmodel.reset(); updateClockTime(); });

        menubar.add(menu);
        menu.add(restart);
        frame.setJMenuBar(menubar);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                JPanel panel = new JPanel(new BorderLayout());
                clockTime[i][j] = new JLabel(String.valueOf(rubikmodel.getClock(i, j).getHour()), SwingConstants.CENTER);
                panel.add(clockTime[i][j], BorderLayout.CENTER);

//                if ((i == 0 && j == 0) || (i == 0 && j == 2) || (i == 2 && j == 0) || (i == 2 && j == 2)) {
//                    panel.add(buttons[x][y], BorderLayout.SOUTH); y++; if (y == 2) { y = 0; x++; }
//                }

                if (i == 1 && j == 1) { // Middle clock
                    JPanel topPanel = new JPanel(new BorderLayout());
                    topPanel.add(buttons[0][0], BorderLayout.WEST);
                    topPanel.add(buttons[0][1], BorderLayout.EAST);
                    panel.add(topPanel, BorderLayout.NORTH);

                    JPanel bottomPanel = new JPanel(new BorderLayout());
                    bottomPanel.add(buttons[1][0], BorderLayout.WEST);
                    bottomPanel.add(buttons[1][1], BorderLayout.EAST);
                    panel.add(bottomPanel, BorderLayout.SOUTH);
                } frame.add(panel);
            }
        } frame.setVisible(true);
    }

    /***
     *  Brings out the button at the given numbers in the Euclidean plane.
     * @param x
     * @param y
     * @return
     */
    public JButton getButton(int x, int y) { return buttons[x][y]; }

    /***
     * Brings out the main frame of the GUI component.
     * @return
     */
    public JFrame getFrame() { return frame; }

    /***
     * Updates the clock times for showing the new hours.
     */
    public void updateClockTime() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) { clockTime[i][j].setText(String.valueOf(rubikmodel.getClock(i, j).getHour())); }
        }
    }
}