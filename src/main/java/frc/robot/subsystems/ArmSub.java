package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ArmSub extends SubsystemBase {
    //Papa = Arm 1, Mama = 2, Baby = 3//
    private final static Talon PapaArm = new Talon(Constants.PWMPort.PapaArmPort);
    private final static Talon MamaArm = new Talon(Constants.PWMPort.MamaArmPort);
    private final static Talon BabyArm = new Talon(Constants.PWMPort.BabyArmPort);

    public void runMotor() {
        
        //if potentiometer value is in range (min-max), then run normally
        if (Constants.StringPot(Constants.PWMPort.PapaArmPort) <= Constants.StringPotLimits.LSArmMax && 
            Constants.StringPot(Constants.PWMPort.PapaArmPort) >= Constants.StringPotLimits.LSArmMin) {
            PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        }
        //else (if potentiometer is not in the range)...
        else {
            //if the potentiometer exceeds the maximum
            if (Constants.StringPot(Constants.PWMPort.PapaArmPort) > Constants.StringPotLimits.LSArmMax) {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) > 0) {
                    PapaArm.set(0);
                }
                else {
                    //set to any value idk
                }

            }
            else {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) < 0) {
                    PapaArm.set(0);
                }
                else {}
            }
            //if pot exceeds 100/max, set input to 0

            //if pot exceeds 0/min 
            PapaArm.set(0);
            //Constants.StringPot(20); //wtf does this even do
        }
        
        if (Constants.StringPot(Constants.PWMPort.MamaArmPort) < 100) {
            MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
        }
        else {
            MamaArm.set(-1);
        }

        if (Constants.StringPot(Constants.PWMPort.BabyArmPort) < 100) {
            BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
        }
        else {
            BabyArm.set(0);
        }

    }

    
}
