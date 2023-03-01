package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;


public class AutoTwo extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    public AutoTwo(DriveSub subsystemOne, ArmSub subsystemTwo) {
        m_driveSub = subsystemOne;
        m_ArmSub = subsystemTwo;
        addRequirements(m_driveSub, m_ArmSub);
        addCommands( 
            new AutoWait(2),
            new AutoArm(m_ArmSub, 1, .28, 2),
            new AutoWait(.5),          
                new AutoArm(m_ArmSub, .80, .82, 1),
                new AutoArm(m_ArmSub, 1, .35, 2),

            //new AutoArm(m_ArmSub, .80, .74, 1),
            new AutoWait(1),
            //new AutoArm(m_ArmSub, 1, .30, 2),
            new AutoWait(2)
            //new AutoArm(m_ArmSub, 1, .2, 2)
        );
    }
}