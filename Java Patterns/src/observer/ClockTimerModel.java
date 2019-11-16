package observer;
// A Sub-class of Observable: a Clock Timer

public class ClockTimerModel extends Observable {
  private int hour;
  private int minute;
  private int second;

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }

  public void tick() {
    // update internal state
    second++;
    if (second >= 60) {
      minute++;
      second = 0;
      if (minute >= 60) {
        hour++;
        minute = 0;
        if (hour >= 24) {
          hour = 0;
        }
      }
    }

    // specify that my state was changed
    // notify all attached Observers of a change
    notifyObservers(this);
  }

  public void start(int secs) {
    for (int i = 1; i <= secs; i++) {
      tick();
    }
  }

}
