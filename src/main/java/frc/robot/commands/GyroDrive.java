package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class GyroDrive extends CommandBase {
    private final DriveSub m_drive;

  public GyroDrive(DriveSub subsystem) {
    m_drive = subsystem;
    addRequirements(m_drive);
  }


  public void initialize() {
  }
  
  @Override
  public void execute() {



    m_drive.balance();

    DriveSub.m_drive.feed();

    

    
  } 

  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
