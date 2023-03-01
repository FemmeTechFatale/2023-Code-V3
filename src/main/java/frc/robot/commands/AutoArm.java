package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSub;

public class AutoArm extends CommandBase {
    
    double localMotorPower;
    double localStringPotTarget;
    int localThreeBears;
    public final ArmSub localArmSub;

    public AutoArm(ArmSub incomingSub, double incomingMotorPower, double StringPotTarget, int ThreeBears) {       
        localArmSub = incomingSub;
    	localMotorPower = incomingMotorPower;
    	localStringPotTarget = StringPotTarget;
        localThreeBears = ThreeBears;
    	addRequirements(localArmSub);
    }

    // Called when the command is initially scheduled.
    public void initialize() {
      localArmSub.autoComplete = false;
    }
    
    // Called every time the scheduler runs while the command is scheduled.
    public void execute() {
        //localArmSub.runAutoMotor(localThreeBears, localMotorPower);
        localArmSub.runAutoMotorv2(localThreeBears, localMotorPower, localStringPotTarget);
    }
  
    // Returns true when the command should end.
    public boolean isFinished() {
      if (localArmSub.autoComplete) {
        return true;
      }
      else {
        return false;
      }
    }

    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {
        localArmSub.motorStop();
    }
   

  }
  