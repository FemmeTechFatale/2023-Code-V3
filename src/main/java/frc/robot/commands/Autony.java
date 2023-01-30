package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Autony extends SequentialCommandGroup{ //imagine the beginning of match
    public Autony() {

        addCommands( 
            
            new AutoDriveTimed(1,2,3),
            //I did random values 

            new ParallelCommandGroup(
            //are we going to need a parallel command group??
            ),
           
            new AutoArm(0),
            //for now...
            //are we doing the arm in Autony
            new AutoWait(1)
            //value for now

        );
    }

    

}

