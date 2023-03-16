package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;


public class AutoPlaceCone extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    int localPlacementLevel;
    public AutoPlaceCone(ArmSub subsystemOne, DriveSub subsystemTwo, int placementLevel) {
        m_ArmSub = subsystemOne;
        m_driveSub = subsystemTwo;
        localPlacementLevel = placementLevel;
        addRequirements(m_ArmSub);

            // Three Bears
            // 1 = MamaArm      Range = .69-.84 (extended-tucked)
            // 2 = BabyArm      Range = .14-.42 (extended-tucked)
            // 3 = Wrist        Range = .135-.265 (up-down)
            //Three bears subtracts one to match correct place
        switch (localPlacementLevel) {
            //level 1
            case 1:

                break;
            //level 2
            case 2:
                addCommands( 
                //drives backwards, raises arm, places cone 
                new AutoDriveTimed(m_driveSub,1.5,-.3,0),
                new AutoWait(.5),
                new AutoArm(m_ArmSub, 1, .293, 2),
                //new AutoArm(m_ArmSub, .80, .78, 1),
                //new AutoArm(m_ArmSub, 1, .36, 2),
                new AutoArm(m_ArmSub, 1, .18, 3),
                new AutoDriveTimed(m_driveSub,1.2,.3,0),
                new AutoWait(.2)
                );
                break;
            //level 3;
            case 3:
            addCommands( 
                //drives backwards, raises arm, places cone 
                new AutoDriveTimed(m_driveSub,1.5,-.3,0),
                new AutoWait(.5),
                new AutoArm(m_ArmSub, 1, .24, 2),
                new AutoArm(m_ArmSub, .80, .793, 1),
                new AutoArm(m_ArmSub, 1, .392, 2),
                new AutoArm(m_ArmSub, 1, .205, 3),
                new AutoDriveTimed(m_driveSub,1.1,.35,0),
                new AutoWait(.2)
                );
                break;
        }
        
    }
}