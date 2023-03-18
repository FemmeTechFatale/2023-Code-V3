package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;
import frc.robot.subsystems.ClawSub;


public class Autony extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    ClawSub m_ClawSub;
    public Autony(DriveSub subsystemOne, ArmSub subsystemTwo, ClawSub subsystemThree) {
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
            //new AutoDriveTimed(m_driveSub, .5, 0, .5),
            new AutoWait(.2),
            new ParallelCommandGroup(
                new AutoDriveTimed(m_driveSub, 2.5, -.6, 0),
                //home
                new PresetThree(m_ArmSub)
            )



        );
    }

    

}

