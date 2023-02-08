package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class GyroMotorSub extends SubsystemBase {
  
    private final static CANSparkMax GyroArm = new CANSparkMax(Constants.CANPort.kGyroArmPort,MotorType.kBrushless);
  


    public static void runMotor() {
        GyroArm.set(0);

        //note: add deadzone angle to the if/else
        if (Constants.GyroReading() < 0) {
            //if gyro angle < 0, run motor forward(?) until angle = 0
            GyroArm.set(0.1);
            //GyroArm.set(RobotContainer.sendAxisValue(Constants.CANPort.kGyroArmPort,1));
            //  ^ above line sets arm power to the axis value of the gyro port??
        }
        else if (Constants.GyroReading() > 0) {
            //if gyro angle > 0, run motor backward until angle = 0
            GyroArm.set(-0.1);
        }
    }
}
