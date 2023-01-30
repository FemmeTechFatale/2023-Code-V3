package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.EncoderDrive;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class Drive extends CommandBase {
  
  private final DriveSub m_drive;

  public Drive(DriveSub subsystem) {
    m_drive = subsystem;
    addRequirements(subsystem);
  }


  public void initialize() {
  }
  
  @Override
  public void execute() {
    m_drive.DifferentialDrive();
    //test limit code
    /*if (Math.abs(Constants.StringPotLimits.LSDriveMax) < Math.abs(DriveSub.RightFront.getEncoder().getPosition())){
      DriveSub.m_drive.arcadeDrive(0, 0);
    }
    else {
    } */
    DriveSub.m_drive.feed();

    

    
  } 

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}