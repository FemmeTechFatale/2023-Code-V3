package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSub;
import frc.robot.Constants;

public class Arm extends CommandBase {

    private final ArmSub localArmSub;
    public Arm(ArmSub incomingSub) {
        localArmSub = incomingSub;
        //Use addRequirements() here to declare subsystem dependencies
        addRequirements(localArmSub);

    }
    
  public void initialize() {}

  //dear Mr. Mathisen, When you see this tmr, you'll probally wonder what I'm doing
  //I don't really know either but I tried really hard. Thanks - lezzles
  public void execute() {
    localArmSub.runMotor();

    /*if (Math.abs(Constants.Limits.LSArmMax) < Math.abs(ArmSub.PapaArm.get())); {
        //for now dawg
        ArmSub.PapaArm.stopMotor();
    }

    if (Math.abs(Constants.Limits.LSArmMin) > Math.abs(ArmSub.PapaArm.get())); {
        //for now dawg
        ArmSub.PapaArm.stopMotor();
    }
    */

    
    
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
