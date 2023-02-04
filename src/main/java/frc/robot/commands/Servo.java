package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ServoSub;

public class Servo extends CommandBase {
  private final ServoSub m_ServoSub;
  private final boolean localDirection;

  /**
   * Creates a new motorForward.
   */
  public Servo(ServoSub servo, boolean direction) {
    m_ServoSub = servo;
    localDirection = direction;
    addRequirements(m_ServoSub);
  }

  @Override
  public void initialize() {

  }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (localDirection) {
            m_ServoSub.servoForward();
        }
        else {
            m_ServoSub.servoBackward();
        }
    }

    public void end(boolean interrupted) {
   
    }
    // Returns true when the command should end.
    public boolean isFinished() {
        return true;
    }


}
