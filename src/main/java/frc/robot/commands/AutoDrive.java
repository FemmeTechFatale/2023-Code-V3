package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;


public class AutoDrive extends CommandBase {
	double outputMagnitude;
	double curve;
	double time;
	Timer localTimeMain = new Timer();

	
    public AutoDrive(double time, double outputMagnitude, double curve) {
     
    	this.outputMagnitude = outputMagnitude;
    	this.curve = curve;
    	this.time = time;
    	
    }

    // Called just before this Command runs the first time
    public void initialize() {
		//Robot.DriveTrain.stop();
		localTimeMain.stop();
		localTimeMain.reset();
		localTimeMain.start();
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
		SmartDashboard.putString("DB/String 1", Double.toString(localTimeMain.get()));
        DriveSub.autoDrive(outputMagnitude, curve);
        
    }
    

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
    	if (localTimeMain.get() > this.time) {
    		return true;
		}
		else {
			return false;
		}
    }

    // Called once after isFinished returns true
    public void end() {
    	//Robot.DriveTrain.stop();
		localTimeMain.stop();
		localTimeMain.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
