package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSub;

public class Claw extends CommandBase {
    
    private final ClawSub localClawSub;
    public static boolean localToggle = false;
    private Timer localTimer = new Timer();

    public Claw(ClawSub incomingSub) {
        localClawSub = incomingSub;
        //Use addRequirements() here to declare subsystem dependencies
        addRequirements(localClawSub);
    }
    
    public void initialize() {
        localTimer.stop();
        localTimer.reset();
        localTimer.start();
    }

    public void execute() {
      if (localToggle) {
        if (localTimer.hasElapsed(2)) {
            localClawSub.runMotor(-1);
        }
        else {
            localClawSub.runMotor(0);
        }
      }
      else {
        if (localTimer.hasElapsed(2)) {
            localClawSub.runMotor(1);
        }
        else {
            localClawSub.runMotor(0);
        }
      }
    }

    public void end(boolean isFinished) {
        localTimer.stop();
        localClawSub.runMotor(0);
        localToggle = !localToggle;
    }
    
    public boolean isFinished() {
        if (localTimer.hasElapsed(3)) {
            return true;
        }
        else {
            return false;
        }
    }
}
