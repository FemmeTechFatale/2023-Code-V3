package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.GyroMotorSub;
import frc.robot.Constants;

public class GyroMotor extends CommandBase {

    private final GyroMotorSub localGyroMotorSub;
    public GyroMotor(GyroMotorSub incomingSub) {
        localGyroMotorSub = incomingSub;
        //Use addRequirements() here to declare subsystem dependencies
        addRequirements(localGyroMotorSub);

    }
    
  public void initialize() {}

  //dear Mr. Mathisen, When you see this tmr, you'll probally wonder what I'm doing
  //I don't really know either but I tried really hard. Thanks - lezzles
  public void execute() {
    localGyroMotorSub.runMotor();
    
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

