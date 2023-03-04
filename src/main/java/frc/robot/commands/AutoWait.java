package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
		//SmartDashboard.putString("DB/String 0", "here we are AutoWait");

		return waitTimer.get() >= this.waittime;
	}

	// Called once after isFinished returns true

	public void end(boolean isFinished) {
        waitTimer.stop();
        waitTimer.reset();
		//SmartDashboard.putString("DB/String 0", "here we are how about here?");

	}

}

