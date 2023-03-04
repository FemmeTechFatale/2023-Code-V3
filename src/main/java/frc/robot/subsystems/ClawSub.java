package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.commands.Claw;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSub extends SubsystemBase {
    
    private final static CANSparkMax ClawController = new CANSparkMax(Constants.CANPort.kClawPort, MotorType.kBrushed);
    //private final static RelativeEncoder ClawEncoder = Claw.getEncoder();
    //private static double clawPosition = ClawEncoder.getPosition();

    public static void runMotor(double motorPower) {
        ClawController.set(motorPower);
    }

    public static void runAutoClaw(double motorPower, boolean closeItDammit) {
        
    }

    //returns a status for display
    /*public static boolean checkStatus() {
        if (Claw.clawStatus){
            return true;
        }
        else {
            return false;
        }
    }
    */



}
