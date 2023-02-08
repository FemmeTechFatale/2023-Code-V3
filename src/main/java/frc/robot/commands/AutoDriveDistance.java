package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class AutoDriveDistance extends CommandBase {
	@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

	double outputMagnitude;
	double curve;
	double distanceRotations;
	double distanceFeet;
	double setpoint;

	//PID controller variables
	double kP;
	double kI;
	double kD;
	PIDController drivePID = new PIDController(kP, kI, kD);
  
	//
	public AutoDriveDistance(double distance, double outputMagnitude) {
		this.distanceFeet = distance;
		this.distanceRotations = distance/Constants.ConversionFormulas.conversionFeet; //feet --> rotations
	  // Use addRequirements() here to declare subsystem dependencies.
	}
  
	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		//change PID values here
		kP = 0.5;
		kI = 0.05;
		kD = 0.05;
		setpoint = distanceFeet;
		Constants.Encoders.driveEncoder.reset();

	}
  
	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		DriveSub.autoDrive(drivePID.calculate(Constants.Encoders.driveEncoder.getDistance(), setpoint), 0);
		// *figure out what to set curve to
	}
  
	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {}
  

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		if (drivePID.atSetpoint()) {
			//try getPositionError() if atSetpoint() doesn't work?
			return true;
		}
		else {
			//else, continue auto
			return false;
		}
	} //might have an issue w/ teleop not restarting after auto is done
  }