package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPort;
import frc.robot.RobotContainer;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain extends SubsystemBase {
    
    public static CANSparkMax LeftFront = new CANSparkMax(CANPort.kLeftMotorFrontPort, MotorType.kBrushless);
    //public static CANSparkMax LeftBack = new CANSparkMax(CANPort.kLeftMotorBackPort, MotorType.kBrushless);
    //static MotorControllerGroup Left = new MotorControllerGroup(LeftFront, LeftBack);

    // The motors on the right side of the drive.
    public static CANSparkMax RightFront = new CANSparkMax(CANPort.kRightMotorFrontPort, MotorType.kBrushless);
    //public static CANSparkMax RightBack = new CANSparkMax(CANPort.kRightMotorBackPort, MotorType.kBrushless);

    //static MotorControllerGroup Right = new MotorControllerGroup(RightFront, RightBack);
   
  
    // The robot's drive
    public static final DifferentialDrive m_drive = new DifferentialDrive(LeftFront, RightFront);

    /**
    * Creates a new DriveSubsystem.
    */
    public DriveTrain() {
        // Sets the distance per pulse for the encoders
      
    }

    public void DifferentialDrive() {
        //m_drive.(false);
        m_drive.arcadeDrive((RobotContainer.m_driverController.getRawAxis(0)*.8), -(RobotContainer.m_driverController.getRawAxis(1)*.8));
      }
    
      /* public static double getPower() {
        return(RightFront.getEncoder());
      } */
    
      public static void autoDrive(double outputMagnitude, double curve) {
        m_drive.arcadeDrive(outputMagnitude, curve);    	
      }

}
