package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSub extends SubsystemBase {
    
    private final static CANSparkMax Claw = new CANSparkMax(Constants.CANPort.kClawPort, MotorType.kBrushed);
    private final static RelativeEncoder ClawEncoder = Claw.getEncoder();
    private static double clawPosition = ClawEncoder.getPosition();

    public static void runMotor(double motorPower) {
        Claw.set(motorPower);
    }

    public static boolean checkStatus() {
        if (clawPosition >= .9){
            return true;
        }
        else {
            return false;
        }
    }




}
