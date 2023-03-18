// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
//import edu.wpi.first.wpilibj.SPI.Port;
import frc.robot.subsystems.ArmSub;

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
    public static final int kLeftMotorBackPort = 3;
    public static final int kRightMotorFrontPort = 4;
    public static final int kRightMotorBackPort = 5;
    public static final int kClawPort = 6;
    public static final int MamaArmPort = 7;
    public static final int BabyArmPort = 8;

  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kArmJoyOnePort = 1;
    public static final int kArmJoyTwoPort = 2;
  }

  public static final class PWMPort {
    public static final int PapaArmPort = 0;
    public static final int WristPort = 1;
    public static final int kGyroArmPort = 3; 
    public static final int ServoOnePort = 7;
    public static final int ServoTwoPort = 8;

  }

  public static final class StringPotLimits {
    public static final double LSArmMin = 1;
    public static final double LSArmMax = 99;

    public static final double maMin = 0;
    public static final double maMax = 282;
    public static final double maMid = ((maMax+maMin)/2);
    public static final double maHalfRange = (((maMax-maMin)/2)-.01);

    public static final double baMin = 0;
    public static final double baMax = 465;
    public static final double baMid = ((baMax+baMin)/2);
    public static final double baHalfRange = (((baMax-baMin)/2)-.01);

    public static final double mamaPotMax = .182; //.84 old new .215
    public static final double mamaPotMin = .08; //.69 old new .05
    public static final double mamaPotMid = ((mamaPotMax+mamaPotMin)/2);
    public static final double mamaHalfRange = (((mamaPotMax-mamaPotMin)/2)-.01);

    public static final double babyPotMax = .42; //.42
    public static final double babyPotMin = .14; //.14
    public static final double babyPotMid = ((babyPotMax+babyPotMin)/2);
    public static final double babyHalfRange = (((babyPotMax-babyPotMin)/2)-.01);

    public static final double wristPotMin = .130;
    public static final double wristPotMax = .265;
    public static final double wristPotMid = ((wristPotMax+wristPotMin)/2);
    public static final double wristHalfRange = (((wristPotMax-wristPotMin)/2)-.01);


  }

  public static final class ConversionFormulas {
    //formula: ticks * ticks/rotation * gear ratio * pi * unit
     public static double conversionFeet = 1/42 * 8.45 * Math.PI * 1/12;
  }
 

  public static final class Encoders {
    //public static Encoder plgEncoder = new Encoder(null, null);
    public static Encoder driveEncoder = new Encoder(2, 3, true, EncodingType.k4X);
  }
  //static SPI.Port hi = new SPI.Port(4));
  //static AnalogGyro driveGyro = new AnalogGyro(0);
  public static ADXRS450_Gyro driveGyro = new ADXRS450_Gyro();
  static DigitalInput papaLeftLimitSwitch = new DigitalInput(0);
  static DigitalInput papaRightLimitSwitch = new DigitalInput(1);

  static AnalogPotentiometer MamaArmBasePot = new AnalogPotentiometer(0);
  static AnalogPotentiometer BabyArmBasePot = new AnalogPotentiometer(1);
  static AnalogPotentiometer WristPot = new AnalogPotentiometer(2);

  public static double GyroReading(){
    return (driveGyro.getAngle()); 
  }

  public static double GyroDeltaReading() {
    return (driveGyro.getRate());
  }
   
  public static boolean LimitSwitch(int limitID) {
    boolean limitState = false;
    
    switch (limitID) {
      case 0:
        limitState = papaLeftLimitSwitch.get();
        break;
      case 1:
        limitState = papaRightLimitSwitch.get();
        break;
    }
    
    return limitState;
  }

  public static double StringPot(int PotID) {
    double potValue = 0;

    switch (PotID) {
      case 0:
        potValue=1-MamaArmBasePot.get();
        break;
      case 1:
        potValue=BabyArmBasePot.get();
        break;
      case 2:
        potValue=WristPot.get();
        break;
    }

    return potValue;
  }

  public static double SPDif(int PotID, double targetValue) {
    return (targetValue - StringPot(PotID));
  }

  //ID 0 - Mama Arm
  //ID 1 - Baby Arm
  public static double neoRead(int neoID) {
    double neoValue = 0;

    switch (neoID) {
      case 0:
        neoValue=ArmSub.mamaNeoRead();
        break;
      case 1:
        neoValue=ArmSub.babyNeoRead();
        break;
    }

    return neoValue;
  }

  //ID 0 - Mama Arm
  //ID 1 - Baby Arm
  public static double neoDif(int neoID, double targetValue) {
    return (targetValue - neoRead(neoID));
  }

}