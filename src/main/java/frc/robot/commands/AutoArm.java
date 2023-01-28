package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.ArmSub;

public class AutoArm extends CommandBase {
    
    private final int m_ValueofArm; //the on and off toggle
    public AutoArm(int ValueofArm) {
        m_ValueofArm = ValueofArm;
    }

    // Called when the command is initially scheduled.
    public void initialize() {

    }
    
    // Called every time the scheduler runs while the command is scheduled.
    public void execute() {
        if (m_ValueofArm == 0)
        {
            ArmSub.runMotor(); 
        }
       /* else if (m_ValueofArm == 1)
        {
            ArmSub.runMotor();
        }
        else if (m_ValueofArm == 2)
        {
            ArmSub.runMotor();
        }  */ 
        else
        {
    
        }

    }
  
    // Called once the command ends or is interrupted.
    public void end(boolean interrupted) {

    }
   
    // Returns true when the command should end.
    public boolean isFinished() {
      return true;
    }
  }
  