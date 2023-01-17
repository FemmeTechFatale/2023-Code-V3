package frc.robot.commands;

import frc.robot.subsystems.ArmSecondarySub;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class ArmSecondary extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ArmSecondarySub m_subsystem;
  private final double m_motorPower;

  public ArmSecondary(ArmSecondarySub subsystem, double motorPower) {
    m_subsystem = subsystem;
    m_motorPower = motorPower;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }
// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
//Testing here! woO!!
//this is a line of code wohoahoaooh
@Override
public void execute() {
    ArmSecondarySub.runIt(m_motorPower);
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return true;
}


}
