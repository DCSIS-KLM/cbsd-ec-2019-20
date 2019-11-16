package observer;

// A specific Observer to observe ClockTimerModel: DigitalClockView

public class DigitalClockView implements Observer {
  public void update(Observable obs) {
    // redraw my clock's reading after I was notified
    int hour = ((ClockTimerModel) obs).getHour();
    int minute = ((ClockTimerModel) obs).getMinute();
    int second = ((ClockTimerModel) obs).getSecond();
    System.out.println(hour + ":" + minute + ":" + second);
  }
}