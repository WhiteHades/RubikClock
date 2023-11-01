import javax.swing.*;

public class rubikController {
    private rubikGUI rubikgui;
    private rubikModel rubikmodel;

    public rubikController(rubikModel rubikmodel, rubikGUI rubikgui) {
        this.rubikmodel = rubikmodel;
        this.rubikgui = rubikgui;
        addListenerAction();
    }

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
