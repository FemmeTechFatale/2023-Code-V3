package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class Drive extends CommandBase {
  
  private final DriveTrain m_drive;

  public Drive(DriveTrain subsystem) {
    m_drive = subsystem;
    addRequirements(m_drive);
  }

  public void initialize() {
  }
  
  @Override
  public void execute() {
    m_drive.DifferentialDrive();
  } 

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}