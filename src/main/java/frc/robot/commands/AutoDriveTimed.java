package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;


public class AutoDriveTimed extends CommandBase {
	double outputMagnitude;
	double curve;
	double time;
	private final DriveSub m_driveSub;
	Timer localTimeMain = new Timer();

	
    public AutoDriveTimed(DriveSub driveSub, double time, double outputMagnitude, double curve) {
     
    	this.outputMagnitude = outputMagnitude;
    	this.curve = curve;
    	this.time = time;
		m_driveSub = driveSub;
		addRequirements(m_driveSub);

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
		//SmartDashboard.putString("DB/String 0", Double.toString(localTimeMain.get()));
        m_driveSub.autoDrive(outputMagnitude, curve);
        
    }
    

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
    	if (localTimeMain.get() > this.time)  {
    		SmartDashboard.putString("DB/String 1", "still true");
			return true;
		}
		else {
			SmartDashboard.putString("DB/String 1", "not true!");

			return false;
		}
    }

    // Called once after isFinished returns true
    public void end() {
    	//Robot.DriveTrain.stop();
		localTimeMain.stop();
		localTimeMain.reset();
		DriveSub.autoDrive(0, 0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
