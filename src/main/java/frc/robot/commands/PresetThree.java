package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;

//preset for
public class PresetThree extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    public PresetThree(ArmSub subsystemOne) {
        m_ArmSub = subsystemOne;
        addRequirements(m_ArmSub);
        addCommands( 
            // Three Bears
            // 1 = MamaArm      Range = .69-.84
            // 2 = BabyArm      Range = .14-.42
            // 3 = Wrist        Range = .135-.265

            //returns arm to starting config
            new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .08, 1), //.69
            //new AutoWait(.5),          
            new AutoArm(m_ArmSub, .80, .32, 2),
            //new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .150, 3),
            //new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .135, 2),
                //three bears subtracts 1
            new AutoArm(m_ArmSub, 1, .135, 4),

            //new AutoArm(m_ArmSub, .80, .74, 1),
            new AutoWait(.2)
            //new AutoArm(m_ArmSub, 1, .30, 2),
        );
    }
}
