package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSub;

public class AutoArm extends CommandBase {
    
    double localMotorPower;
    double localStringPotLimits;
    double localThreeBears;
    private final ArmSub localArmSub;

    public AutoArm(ArmSub incomingSub, double incomingMotorPower, double StringPotLimits, int ThreeBears) {       
        localArmSub = incomingSub;
    	localMotorPower = incomingMotorPower;
    	localStringPotLimits = StringPotLimits;
        localThreeBears = ThreeBears;
    	addRequirements(localArmSub);
    }

    // Called when the command is initially scheduled.
    public void initialize() {

    }
    
    // Called every time the scheduler runs while the command is scheduled.
    public void execute() {
        //localArmSub.runAutoMotor(localMotorPower, localThreeBears);
    }
  
    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {

    }
   
    // Returns true when the command should end.
    public boolean isFinished() {
      if (Constants.StringPot(0) >= localStringPotLimits) {
        //localArmSub.runAutoMotor(0);
        return true;
      }
      else {
        return false;
      }
    }
  }
  