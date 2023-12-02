import java.util.Random;

/***
 * The rubikModel (Model) class. It's associated with clockModel to show that it contains an array of clockModel instances
 */
public class rubikModel {
    private clockModel[][] clockmodel = new clockModel[3][3];
    Random random = new Random();
    private int steps;

    /***
     * The constructor.
     */
    public rubikModel() {
        for (int i=0; i<3; i++) { for (int j=0; j<3; j++) { clockmodel[i][j]= new clockModel(); } }
        steps = 0;
    }

    /***
     * Brings out the clock time at the given numbers in the Euclidean plane.
     * @param x
     * @param y
     * @return
     */
    public clockModel getClock(int x, int y) { return clockmodel[x][y]; }

    /***
     * When pressed, updates the adjacent clocks time by adding 1 (hour).
     * @param x
     * @param y
     */
    public void pressButton(int x, int y) {
        steps++;
        for (int i=x; i<=x+1; i++) { for (int j=y; j<=y+1; j++) { clockmodel[i][j].increaseHour(); } }
    }

    /***
     *  Returns the true if all the clocks time is 12 (hours).
     * @return
     */
    public boolean checkWin() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) { if (clockmodel[i][j].getHour() != 12) { return false; } }
        } return true;
    }

    /***
     * Returns the frequency of the button pressed after which all the clocks time are 12 (hours).
     * @return
     */
    public int getSteps() { return steps; }

    /***
     * Resets the game to the beginning stage.
     */
    public void reset() {
        for (int i=0; i<3; i++) { for (int j=0; j<3; j++) { clockmodel[i][j]= new clockModel(); } }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int presses = random.nextInt(5);
                for (int k = 0; k < presses; k++) pressButton(i, j);
            }
        }
        steps = 0;
    }
}
