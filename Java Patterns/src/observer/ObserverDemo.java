package observer;

import java.util.Scanner;

public class ObserverDemo {

  public static void main(String[] av) {
    DigitalClockView clockView;
    ClockTimerModel clockModel;

    // create the View object
    clockView = new DigitalClockView();
    // create the Model object
    clockModel = new ClockTimerModel();
    // connect the View object to the Model object
    clockModel.attach(clockView);

    Scanner kbd = new Scanner(System.in);
    int secs = kbd.nextInt();
    clockModel.start(secs);
    kbd.close();
  }
}
