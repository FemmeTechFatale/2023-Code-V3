package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;


public class AutoWait extends CommandBase {
    double waittime;
    Timer waitTimer = new Timer();
    public AutoWait(double time) {
        this.waittime = time;
    }

		// Use requires() here to declare subsystem dependencies

	// Called just before this Command runs the first time
	public void initialize() {
        waitTimer.start();
	}

	// Called repeatedly when this Command is scheduled to run

	public void execute() {
	//	WinchSub.setMotor(1);

	}

	public boolean isFinished() {
		return waitTimer.get() >= this.waittime;
	}

	// Called once after isFinished returns true

	public void end() {
        waitTimer.stop();
        waitTimer.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	public void interrupted() {
		end();
	}
}

