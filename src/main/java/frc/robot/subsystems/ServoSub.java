
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ServoSub extends SubsystemBase {
  Servo ServoOne = new Servo(Constants.PWMPort.ServoOnePort);
  Servo ServoTwo = new Servo(Constants.PWMPort.ServoTwoPort);  

  //channel for now
  //channel for now

  public ServoSub() {

  }
    //claw open
    public void servoForward() {

      ServoOne.set(0.73);
      ServoTwo.set(.28);
      //Value for now
      
    
    }

    // claw closed
    public void servoBackward() {
      ServoOne.set(0.28);
      ServoTwo.set(0.73);
      //value for now
        
    }
    
    
    









}