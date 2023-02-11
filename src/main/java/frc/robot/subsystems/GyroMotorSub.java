package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class GyroMotorSub extends SubsystemBase {
  
    private final static Talon GyroArm = new Talon(Constants.PWMPort.kGyroArmPort);
  


    public static void runMotor() {
       
        GyroArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0));
        
        //goal: auto-adjust gyro angle while the arm moves
        /*GyroArm.set(0);

        //note: add deadzone angle to the if/else
        if (Constants.GyroReading() < 0) {
            //if gyro angle < 0, run motor forward(?) until angle = 0
            GyroArm.set(0.1);
            //GyroArm.set(RobotContainer.sendAxisValue(Constants.CANPort.kGyroArmPort,1));
            //  ^ above line sets arm power to the axis value of the gyro port? i think?
        }
        else if (Constants.GyroReading() > 0) {
            //if gyro angle > 0, run motor backward until angle = 0
            GyroArm.set(-0.1);
        }*/
    }
}
