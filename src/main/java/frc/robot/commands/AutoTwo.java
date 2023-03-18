package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;


public class AutoTwo extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    public AutoTwo(ArmSub subsystemOne, DriveSub subsystemTwo) {
        m_ArmSub = subsystemOne;
        m_driveSub = subsystemTwo;
        addRequirements(m_ArmSub);
        addCommands( 
            // Three Bears
            // 1 = MamaArm      Range = .69-.84 (extended-tucked)
            // 2 = BabyArm      Range = .14-.42 (extended-tucked)
            // 3 = Wrist        Range = .135-.265 (up-down)

            //drives backwards, raises arm, places cone 
            new AutoDriveTimed(m_driveSub,1,-.45,0),

            new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .24, 2),
            //new AutoWait(.5),          
                new AutoArm(m_ArmSub, .80, .14, 1), //.78
                //new AutoWait(.5),
                new AutoArm(m_ArmSub, 1, .348, 2),
                //new AutoWait(.5),
                new AutoArm(m_ArmSub, 1, .22, 3),
                //three bears subtracts 1
                new AutoDriveTimed(m_driveSub,.34,.3,0),
                

            //new AutoArm(m_ArmSub, .80, .74, 1),
            new AutoWait(.2)
            //new AutoArm(m_ArmSub, 1, .30, 2),
        );
    }
}