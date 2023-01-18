package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSub;

public class Arm extends CommandBase {

    private ArmSub localArmSub;
    public Arm(ArmSub incomingSub) {
        localArmSub = incomingSub;
        //Use addRequirements() here to declare subsystem dependencies
        addRequirements(localArmSub);

    }
    
  public void initialize() {}

  public void execute() {
    localArmSub.runMotor();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean isFinished) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
