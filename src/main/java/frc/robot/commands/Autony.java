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
            new AutoWait(1),
            new Claw(m_ClawSub),
            new AutoDriveTimed(m_driveSub,2,.5,0),
            //new AutoWait(2),
            //new AutoDriveTimed(m_driveSub, .5, 0, .5),
            new AutoWait(1.5)
            //new AutoDriveTimed(m_driveSub, .5, 0, -.5)

            //new AutoDriveDistance(3, 1),

            //new AutoWait(5)

            //new AutoDriveTimed(5,0.5,10)

            //new AutoArm(m_ArmSub, .5, 100, 0)

            /*
            new ParallelCommandGroup(
            //are we going to need a parallel command group??
            ),
           
            new AutoArm(0),
            //for now...
            //are we doing the arm in Autony
            

            new AutoDriveTimed(1, 2, 3)
            //value for now 

            */

        );
    }

    

}

