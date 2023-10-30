import java.time.Clock;

public class rubikModel {
    private clockModel[][] clock = new clockModel[3][3];
    private int steps;

    public rubikModel() {
        for (int i=0; i<3; i++) { for (int j=0; j<3; j++) { clock[i][j]= new clockModel(); } }
        steps = 0;
    }

    public clockModel getClock(int x, int y) { return clock[x][y]; }

    public void pressButton(int x, int y) {
        steps++;
        for (int i=x; i<=x+1; i++) { for (int j=y; j<=y+1; j++) { clock[i][j].increaseHour(); } }
    }

    public boolean checkWin() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) { if (clock[i][j].getHour() != 12) { return false; } }
        } return true;
    }

    public int getSteps() { return steps; }

    public void reset() {
        for (int i=0; i<3; i++) { for (int j=0; j<3; j++) { clock[i][j]= new clockModel(); } }
        steps = 0;
    }
}
