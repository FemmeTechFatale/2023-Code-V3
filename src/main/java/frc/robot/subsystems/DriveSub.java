package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
//import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANPort;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSub extends SubsystemBase {
    
    //public static CANSparkMax LeftFront = new CANSparkMax(CANPort.kLeftMotorFrontPort, MotorType.kBrushless);
    //public static CANSparkMax LeftBack = new CANSparkMax(CANPort.kLeftMotorBackPort, MotorType.kBrushless);
    //static MotorControllerGroup Left = new MotorControllerGroup(LeftFront, LeftBack);
    public static Talon LeftFront = new Talon(CANPort.kLeftMotorFrontPort);
    public static Talon LeftBack = new Talon(CANPort.kLeftMotorBackPort);
    static MotorControllerGroup Left = new MotorControllerGroup(LeftFront, LeftBack);


    // The motors on the right side of the drive.
    public static Talon RightFront = new Talon(CANPort.kRightMotorFrontPort);
    public static Talon RightBack = new Talon(CANPort.kRightMotorBackPort);
    static MotorControllerGroup Right = new MotorControllerGroup(RightFront, RightBack);
    


    //public static CANSparkMax RightBack = new CANSparkMax(CANPort.kRightMotorBackPort, MotorType.kBrushless);

    //static MotorControllerGroup Right = new MotorControllerGroup(RightFront, RightBack);
   
  
    // The robot's drive
    public static final DifferentialDrive m_drive = new DifferentialDrive(Left, Right);

    /**
    * Creates a new DriveSubsystem.
    */
    public DriveSub() {
        // Sets the distance per pulse for the encoders
        RightFront.setInverted(true);
        RightBack.setInverted(true);
        
    }

    public void DifferentialDrive() {
      m_drive.arcadeDrive(RobotContainer.sendAxisValue(Constants.OperatorConstants.kDriverControllerPort,1),
      -RobotContainer.sendAxisValue(Constants.OperatorConstants.kDriverControllerPort,0));     
      
      //if (Constants.StringPot(Constants.OperatorConstants.kDriverControllerPort) < 100) {
        //Left.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kDriverControllerPort,1));
        //Right.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kDriverControllerPort,1));
      //}
      //else {
      //  LeftFront.set(0);
      //  RightFront.set(0);
      //}

      }
    
    
      /* public static double getPower() {
        return(RightFront.getEncoder());
      } */
    
      public static void autoDrive(double outputMagnitude, double curve) {
        m_drive.arcadeDrive(outputMagnitude, curve);    	
      }

}
