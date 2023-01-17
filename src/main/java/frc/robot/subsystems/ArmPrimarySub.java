// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PWMPort;

public class ArmPrimarySub extends SubsystemBase {
    public static Talon talonArmPrime = new Talon(PWMPort.kArmPrimary);
    
  

    /** Creates a new ExampleSubsystem. */
  public ArmPrimarySub() {

  }

  /**
   * Example command factory method.
   *
   * @return a command
   
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          // one-time action goes here //
        });
  }
  */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }

public void runIt(double motorPower) {
  //SmartDashboard.putString("DB/String 0", "Primary before motor set");
  talonArmPrime.set(motorPower);
}

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
