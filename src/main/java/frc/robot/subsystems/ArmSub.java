package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ArmSub extends SubsystemBase {
    //Papa = Arm 1, Mama = 2, Baby = 3//
    private final Talon PapaArm = new Talon(Constants.PWMPort.PapaArmPort);
    private final Talon MamaArm = new Talon(Constants.PWMPort.MamaArmPort);
    private final Talon BabyArm = new Talon(Constants.PWMPort.BabyArmPort);

    public void runMotor() {
        
        PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
        BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));


    }

    
}
