import java.util.Random;
/***
 * The clockModel (Model) class. It's not directly associated with other classes since it doesn't have any direct
 * interactions,
 * rather, other classes use said model for their respective purposes
 */
public class clockModel {
    private int hour;

    /***
     * The constructor.
     */
    public clockModel() { hour = new Random().nextInt(12) + 1; }

    /***
     *  Returns the current time on the respective clock.
     * @return it returns the private hour.
     */
    public int getHour() { return hour; }

    /***
     * Increases the clock’s time (hour) by one, in a 12-hour format.
     */
    public void increaseHour() { hour = (hour%12) + 1; }
}