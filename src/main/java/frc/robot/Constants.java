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
import edu.wpi.first.wpilibj.SPI.Port;

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

    public static final double mamaPotMax = .7;
    public static final double mamaPotMin = .4;
    
    public static final double babyPotMax = .8;
    public static final double babyPotMin = .5;

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
  static ADXRS450_Gyro driveGyro = new ADXRS450_Gyro();
  //static ADXRS450_Gyro clawGyro = new ADXRS450_Gyro(SPI.Port.kMXP);
  static DigitalInput toplimitSwitch = new DigitalInput(2);
  static AnalogPotentiometer MamaArmBasePot = new AnalogPotentiometer(0);
  static AnalogPotentiometer BabyArmBasePot = new AnalogPotentiometer(1);
  //static AnalogPotentiometer BabyArmBasePot = new AnalogPotentiometer(1);

  //DigitalInput bottomlimitSwitch = new DigitalInput(1);

  public static double GyroReading(){
    return driveGyro.getAngle(); 
    
  }
   
  public static boolean LimitSwitch(int limitID) {
    boolean limitState = false;
    
    switch (limitID) {
      case 0:
        limitState = toplimitSwitch.get();
        break;
    }
    
    return limitState;
  }

  public static double StringPot(int PotID) {
    double potValue = 0;

    switch (PotID) {
      case 0:
        potValue=MamaArmBasePot.get();
        break;
      case 1:
        potValue=BabyArmBasePot.get();
        break;
    }
    return potValue;
  }

  public static double SPDif(int PotID, double targetValue) {
    return (targetValue - StringPot(PotID));
  }

}