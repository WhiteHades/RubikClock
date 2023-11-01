import javax.swing.*;


/***
 * The rubikController (Controller) class. It's associated with both rubikModel and rubikGUI to indicate that it
 * controls and interacts with these classes.
 */
public class rubikController {
    private rubikGUI rubikgui;
    private rubikModel rubikmodel;

    /***
     * The constructor. Initialises the rubikmodel and rubikgui to the given ones.
     * @param rubikmodel the model. having the backbone of the gui.
     * @param rubikgui the gui. having the pictoral representation of the software.
     */
    public rubikController(rubikModel rubikmodel, rubikGUI rubikgui) {
        this.rubikmodel = rubikmodel;
        this.rubikgui = rubikgui;
        addListenerAction();
    }


    /***
     * Adds the action listeners for buttons, allowing the game, to effectively, run.
     */
    private void addListenerAction() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int x = i;
                int y = j;
                rubikgui.getButton(i, j).addActionListener(e -> {
                    rubikmodel.pressButton(x, y);
                    rubikgui.updateClockTime();
                    if (rubikmodel.checkWin()) { JOptionPane.showMessageDialog(rubikgui.getFrame(),
                            "Well done. You win. In steps: " + rubikmodel.getSteps(),
                                "Finished Game",
                                JOptionPane.INFORMATION_MESSAGE);
                        rubikmodel.reset();
                        rubikgui.updateClockTime();
                    }
                });
            }
        }
    }
}
