package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSub;

public class Claw extends CommandBase {
    
    private final ClawSub localClawSub;
    public static boolean clawStatus = false;
    private double localMotorPower;
    public Claw(ClawSub incomingSub, double incomingMotorPower) {
        localClawSub = incomingSub;
        localMotorPower = incomingMotorPower;
        //Use addRequirements() here to declare subsystem dependencies
        addRequirements(localClawSub);
    }
    
    public void initialize() {
        clawStatus = true;
    }

    public void execute() {
        localClawSub.runMotor(0);
         
    }

    public void end(boolean isFinished) {
        localClawSub.runMotor(0);
        clawStatus = false;
    }
    
    public boolean isFinished() {
        return false;
    }
}
