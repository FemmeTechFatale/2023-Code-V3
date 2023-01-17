package frc.robot.commands;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class EncoderDrive extends CommandBase {
    public static RelativeEncoder m_rightEncoder;
    double m_target;
    double m_speed;
    /** Creates a new EncoderDrive. */
  
    /**Drives to a target number of rotations. Use speed to change direction not target
     * @param target Number of wheel rotations to go to
     * @param speed positive is forward, negative is backward
     */
    public EncoderDrive(double target, double speed) {
      // Use addRequirements() here to declare subsystem dependencies.
      m_target = target;
      m_speed = speed;

    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      m_rightEncoder = DriveTrain.RightFront.getEncoder();
      m_rightEncoder.setPosition(0);
      DriveTrain.LeftFront.setIdleMode(IdleMode.kBrake);
      //DriveTrain.LeftBack.setIdleMode(IdleMode.kBrake);
      DriveTrain.RightFront.setIdleMode(IdleMode.kBrake);
      //DriveTrain.RightBack.setIdleMode(IdleMode.kBrake);
      DriveTrain.m_drive.feed();
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      if(Math.abs(m_target) < Math.abs(m_rightEncoder.getPosition())){
        DriveTrain.m_drive.arcadeDrive(0, 0);
      }else{
        DriveTrain.m_drive.arcadeDrive(m_speed, 0);
      }
      DriveTrain.m_drive.feed();
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        DriveTrain.m_drive.arcadeDrive(0, 0); 
        DriveTrain.m_drive.feed();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      if(Math.abs(m_target) < Math.abs(m_rightEncoder.getPosition())){
        DriveTrain.m_drive.arcadeDrive(0, 0);
        DriveTrain.m_drive.feed();
        return true;
      }else{
        DriveTrain.m_drive.feed();
        return false;
      }
    }
  }

/*code that might be used later:

 * LeftFront.getMotorTemperature();
 */
