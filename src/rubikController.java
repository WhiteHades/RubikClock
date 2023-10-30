import javax.swing.*;

public class rubikController {
    private rubikGUI gui;
    private rubikModel rubikmodel;

    public rubikController(rubikModel rubikmodel, rubikGUI gui) {
        this.rubikmodel = rubikmodel;
        this.gui = gui;
        setupListeners();
    }

    private void setupListeners() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                final int x = i;
                final int y = j;
                gui.getButton(i, j).addActionListener(e -> {
                    rubikmodel.pressButton(x, y);
                    gui.updateClockDisplays();
                    if (rubikmodel.checkWin()) {
                        JOptionPane.showMessageDialog(gui.getFrame(),
                                "Congratulations! You won in " + rubikmodel.getSteps() + " steps.",
                                "Game Over",
                                JOptionPane.INFORMATION_MESSAGE);
                        rubikmodel.reset();
                        gui.updateClockDisplays();
                    }
                });
            }
        }
    }
}
