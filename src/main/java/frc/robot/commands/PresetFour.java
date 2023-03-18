package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;


public class PresetFour extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    ClawSub m_ClawSub;
    public PresetFour(DriveSub subsystemOne, ArmSub subsystemTwo, ClawSub subsystemThree) {
        m_driveSub = subsystemOne;
        m_ArmSub = subsystemTwo;
        m_ClawSub = subsystemThree;
        addRequirements(m_driveSub, m_ArmSub);
        addCommands( 
            //forward for 5s, wait 5s, turn around, forward 5s
            //new AutoWait(1),
            new Claw(m_ClawSub),
                new AutoPlaceCone(m_ArmSub, m_driveSub, 2),
                new Claw(m_ClawSub),
            
            new AutoDriveTimed(m_driveSub, .3, -.3, 0),
            //new AutoWait(.2),
            //home
            new ParallelCommandGroup(
                new PresetThree(m_ArmSub),
                new AutoDriveBalance(m_driveSub, 10, -.6, 0)
            )



        );
    }

    

}

