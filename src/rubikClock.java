import java.util.Random;

public class rubikClock {
    private int hour;

    public rubikClock() { hour = new Random().nextInt(12) + 1; }
    public int getHour() { return hour; }

    public void increaseHour() { hour = (hour%12) + 1; }
}
