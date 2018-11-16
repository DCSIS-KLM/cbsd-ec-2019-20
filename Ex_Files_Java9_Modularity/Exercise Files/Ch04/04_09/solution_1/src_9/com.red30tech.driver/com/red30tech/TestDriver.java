package com.red30tech.driver;

import com.red30tech.chassis.api.Chassis;
import com.red30tech.chassis.type.SuvChassis;

/**
 * Uses the ServiceProvider to get an implementation of Chassis and takes it out for a test drive.
 */
public class TestDriver {

  private static Chassis getChassis() {
      // Hard coded to SuvChassis
      return new SuvChassis();
  }

  public static void testDrive(Chassis chassis) throws Exception {
     while ((double) chassis.getVelocityInKph() < 100) {
        double currentSpeed = chassis.getVelocityInKph();
        System.out.println("Increasing velocity of Driver..." + (int) currentSpeed);
        chassis.increaseVelocity();
     }

     while ((double) chassis.getVelocityInKph() > 0) {
        double currentSpeed = (Double) chassis.getVelocityInKph();
        System.out.println("Decreasing velocity of Driver..." + (int) currentSpeed);
        chassis.decreaseVelocity();
     }
  }

  public static void main(String... args) {
     try {
        Chassis chassis = getChassis();
        testDrive(chassis);
        System.out.println("Airbags in working condition: " + chassis.testAirbag());
     }
     catch (Exception e) {
        e.printStackTrace();
     }
   }
}
