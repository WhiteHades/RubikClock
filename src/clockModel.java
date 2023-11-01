import java.util.Random;

public class clockModel {
    private int hour;
    public clockModel() { hour = new Random().nextInt(12) + 1; }
    public int getHour() { return hour; }
    public void increaseHour() { hour = (hour%12) + 1; }
}