package frc.robot.commands;

import frc.robot.subsystems.ArmRotateSub;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmRotate extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArmRotateSub m_subsystem;
  private final double m_motorPower;

  public ArmRotate(ArmRotateSub subsystem, double motorPower) {
    m_subsystem = subsystem;
    m_motorPower = motorPower;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
//Testing here! woO!!
//this is a line of code wohoahoaooh
@Override
public void execute() {
    m_subsystem.runIt(m_motorPower);
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}


}
