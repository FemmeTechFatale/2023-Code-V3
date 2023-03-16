package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ArmSub;


public class PresetFive extends SequentialCommandGroup{ //imagine the beginning of match
    
    DriveSub m_driveSub;
    ArmSub m_ArmSub;
    public PresetFive(DriveSub subsystemOne, ArmSub subsystemTwo) {
        m_driveSub = subsystemOne;
        m_ArmSub = subsystemTwo;
        addRequirements(m_driveSub, m_ArmSub);
        addCommands( 
            // Three Bears
            // 1 = MamaArm      Range = .69-.84 (extended-tucked)
            // 2 = BabyArm      Range = .14-.42 (extended-tucked)
            // 3 = Wrist        Range = .135-.265 (up-down)
            
            //arm extension lvl 2 config
            new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .24, 2),
            new AutoWait(.5),          
            new AutoArm(m_ArmSub, .80, .82, 1),
            new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .32, 2),
            new AutoWait(.5),
            new AutoArm(m_ArmSub, 1, .2, 3),
                //three bears subtracts 1
                

            //new AutoArm(m_ArmSub, .80, .74, 1),
            new AutoWait(1)
            //new AutoArm(m_ArmSub, 1, .30, 2),
        );
    }
}