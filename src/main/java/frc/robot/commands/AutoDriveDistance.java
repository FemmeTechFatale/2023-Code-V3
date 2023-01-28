package frc.robot.commands;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;
import frc.robot.Constants;
import frc.robot.Constants.ConversionFormulas;

/** An example command that uses an example subsystem. */
public class AutoDriveDistance extends CommandBase {
	@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

	double outputMagnitude;
	double curve;
	double distanceRotations;
	double distanceFeet;

	private static RelativeEncoder m_rightEncoder;
  
	//
	public AutoDriveDistance(double distance, double outputMagnitude) {
		this.distanceFeet = distance;
		this.distanceRotations = distance/Constants.ConversionFormulas.conversionFeet; //feet --> rotations
	  // Use addRequirements() here to declare subsystem dependencies.
	}
  
	// Called when the command is initially scheduled.
	@Override
	public void initialize() {}
  
	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		DriveSub.autoDrive(outputMagnitude, curve);
	  
	}
  
	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {}
  

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		if (distanceFeet < Math.abs(m_rightEncoder.getPosition())) {
			//if current position is greater than target distance, finish command
			return true;
		}
		else {
			//else, continue auto
			return false;
		}
	} //might have an issue w/ teleop not restarting after auto is done
  }