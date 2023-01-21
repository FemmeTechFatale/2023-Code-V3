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
        
        //code should stop motors if the limit is hit
        if (Constants.StringPot(Constants.PWMPort.PapaArmPort) < 100) {
            PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        }
        else {
            PapaArm.set(0);
            Constants.StringPot(20); //wtf does this even do
        }
        
        if (Constants.StringPot(Constants.PWMPort.MamaArmPort) < 100) {
            MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
        }
        else {
            MamaArm.set(0);
        }

        if (Constants.StringPot(Constants.PWMPort.BabyArmPort) < 100) {
            BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
        }
        else {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1) >
            BabyArm.set(0);
        }

    }

    
}
