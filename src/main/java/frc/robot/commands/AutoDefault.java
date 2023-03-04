package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;

public class AutoDefault extends SequentialCommandGroup{ //imagine the beginning of match
    
    ArmSub m_ArmSub;
    ClawSub m_ClawSub;
    public AutoDefault(ArmSub subsystemOne, ClawSub subsystemTwo) {
        m_ArmSub = subsystemOne;
        m_ClawSub = subsystemTwo;
        addRequirements(m_ArmSub, m_ClawSub);
        addCommands( 
            //return arm to starting position
            //conditional? run until potentiometer < x
        );
    }

    private void checkPotDistance(ArmSub incomingsub, double potentiometer, double limit) {
        if (potentiometer > limit){

        }
    }
}
