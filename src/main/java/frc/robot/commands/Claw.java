package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSub;

public class Claw extends CommandBase {
    
    private final ClawSub localClawSub;
    public boolean clawStatus;
    private double localMotorPower;
    public Claw(ClawSub incomingSub, double incomingMotorPower) {
        localClawSub = incomingSub;
        localMotorPower = incomingMotorPower;
        //Use addRequirements() here to declare subsystem dependencies
        addRequirements(localClawSub);
    }
    
    public void initialize() {
    }

    public void execute() {
        ClawSub.runMotor(localMotorPower);
        clawStatus = ClawSub.checkStatus();
        
    }

    public void end(boolean isFinished) {
        ClawSub.runMotor(0);
    }
    
    public boolean isFinished() {
        return false;
    }
}
