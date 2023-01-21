// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class CANPort {
    public static final int kLeftMotorFrontPort = 2;
    //public static final int kLeftMotorBackPort = 3;
    public static final int kRightMotorFrontPort = 3;
    //public static final int kRightMotorBackPort = 4;
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kArmJoyOnePort = 1;
    public static final int kArmJoyTwoPort = 2;
  }

  public static final class PWMPort {
    public static final int PapaArmPort = 0;
    public static final int MamaArmPort = 1;
    public static final int BabyArmPort = 2;
  }

  public static final class Limits {
    public static final double LSArmMax = 100;
    public static final double LSArmMin = 0;
    
    public static final double LSDriveMax = 100;
    public static final double LSDriveMin = 0;

  }
  



}