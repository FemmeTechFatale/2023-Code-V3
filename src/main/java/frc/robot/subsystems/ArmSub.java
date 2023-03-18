package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Arm;

public class ArmSub extends SubsystemBase {
    //Papa = Arm 0, Mama = 1, Baby = 2, Wrist = 3//
    public static boolean autoComplete = false;
    private final static Talon PapaArm = new Talon(Constants.PWMPort.PapaArmPort);
    private final static CANSparkMax MamaArm = new CANSparkMax(Constants.CANPort.MamaArmPort, MotorType.kBrushless);
    private final static CANSparkMax BabyArm = new CANSparkMax(Constants.CANPort.BabyArmPort, MotorType.kBrushless);
    private final static Talon Wrist = new Talon(Constants.PWMPort.WristPort);

    public static boolean runAutoMotorv2(int armBearNumber, double incomingPower, double targetValue) {
        switch(armBearNumber) {
            case 0:
                //Needs limit switch code
                PapaArm.set(0);
                autoComplete = true;
                break;
            case 1:
                if (Constants.SPDif(armBearNumber-1, targetValue) > .005) {
                    MamaArm.set(-incomingPower);
                    //SmartDashboard.putString("DB/String 0", "WHOOOOA");

                }
                else if (Constants.SPDif(armBearNumber-1, targetValue) < -.005) {
                    MamaArm.set(incomingPower);
                    //SmartDashboard.putString("DB/String 0", "AHHHHH");

                }
                else {
                    MamaArm.set(0);
                    autoComplete = true;
                    //SmartDashboard.putString("DB/String 0", "here we are!");

                }
                break;
            case 2:
                if (Constants.SPDif(armBearNumber-1, targetValue) > .005) {
                    BabyArm.set(-incomingPower);
                }
                else if (Constants.SPDif(armBearNumber-1, targetValue) < -.005) {
                    BabyArm.set(incomingPower);
                }
                else {
                    BabyArm.set(0);
                    autoComplete = true;
                }
                break;
            case 3:
                //What feedback do we have for the wrist?
                if (Constants.SPDif(armBearNumber-1, targetValue) > .005) {
                    Wrist.set(incomingPower);
                }
                else if (Constants.SPDif(armBearNumber-1, targetValue) < -.005) {
                    Wrist.set(-incomingPower);
                }
                else {
                    Wrist.set(0);
                    autoComplete = true;
                }
                break;
            case 4:
                MamaArm.set(0);
                BabyArm.set(0);
                Wrist.set(0);
                autoComplete = true;
        }
        return autoComplete;
    }


    public static void runAutoMotor(int armBearNumber, double incomingPower) {
    
    //double axisOutput = 0;
        switch(armBearNumber) {
            case 0:
                if((Constants.StringPot(Constants.PWMPort.PapaArmPort) <= Constants.StringPotLimits.LSArmMax) && 
                    (Constants.StringPot(Constants.PWMPort.PapaArmPort) >= Constants.StringPotLimits.LSArmMin)) {
                        PapaArm.set(incomingPower);
                }
                //else if potentiometer is above the range...
                else if (Constants.StringPot(Constants.PWMPort.PapaArmPort) > Constants.StringPotLimits.LSArmMax) {
                    if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) > 0) {
                        PapaArm.set(0);
                    }
                    else {
                        PapaArm.set(incomingPower);
                    }
                }
                //else if potentiometer is below the range
                else {
                    if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) < 0) {
                        PapaArm.set(0);
                    }
                    else {
                        PapaArm.set(incomingPower);
                    }
                }
            break; //case 0 break
            case 1:
                MamaArm.set(incomingPower);
            break;
            case 2:
                BabyArm.set(incomingPower);
            break;
            case 3:
                Wrist.set(incomingPower);
            break;
         }
        
        //PapaArm.set(incomingPower);

    } 


    public static void runMotor() {

        //Papa is beholdant to limit switches regardless of mode
        if (Constants.LimitSwitch(0)) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2) > 0) {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
            }
            else {
                PapaArm.set(0);
            }
        }
        else if (Constants.LimitSwitch(1)) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2) < 0) {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
            }
            else {
                PapaArm.set(0);
            }
        }
        else {
            PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
        }

        ////No limits on arm motion////
        //PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
        MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
        BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 0)*.5);
    } //end of runMotor

    public static void runMotorLimits() {
        ////Limits. Not set to anything particular as of yet, not testing with string pots////
    
        //if potentiometer value is in range (min-max), then run normally
        //papa arm pot
        if((Constants.StringPot(Constants.PWMPort.PapaArmPort) <= Constants.StringPotLimits.LSArmMax) && 
            (Constants.StringPot(Constants.PWMPort.PapaArmPort) >= Constants.StringPotLimits.LSArmMin)) {
            PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        }
        //else (if potentiometer is not in the range)...
        else if (Constants.StringPot(Constants.PWMPort.PapaArmPort) > Constants.StringPotLimits.LSArmMax) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) > 0) {
                PapaArm.set(0);
            }
            else {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1));
            }
        }
        else {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) < 0) {
                PapaArm.set(0);
            }
            else {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1));
            }
        } 


        //if potentiometer value is in range (min-max), then run normally
        //mama arm pot
        if((Constants.StringPot(Constants.CANPort.MamaArmPort) <= Constants.StringPotLimits.LSArmMax) && 
            (Constants.StringPot(Constants.CANPort.MamaArmPort) >= Constants.StringPotLimits.LSArmMin)) {
            MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        }
        //else (if potentiometer is not in the range)...
        else if (Constants.StringPot(Constants.CANPort.MamaArmPort) > Constants.StringPotLimits.LSArmMax) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) > 0) {
                MamaArm.set(0);
            }
            else {
                MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1));
            }
        }
        else {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) < 0) {
                MamaArm.set(0);
            }
            else {
                MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1));
            }
        }


        //if potentiometer value is in range (min-max), then run normally
        //baby arm pot
        if((Constants.StringPot(Constants.CANPort.BabyArmPort) <= Constants.StringPotLimits.LSArmMax) && 
            (Constants.StringPot(Constants.CANPort.BabyArmPort) >= Constants.StringPotLimits.LSArmMin)) {
            BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        }
        //else (if potentiometer is not in the range)...
        else if (Constants.StringPot(Constants.CANPort.BabyArmPort) > Constants.StringPotLimits.LSArmMax) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) > 0) {
                BabyArm.set(0);
            }
            else {
                BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1));
            }
        }
        else {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1) < 0) {
                BabyArm.set(0);
            }
            else {
                BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 1));
            }
        }
    } //end of runMotorLimits

    public static void runMotorLimitsv2() {

        if (Constants.StringPot(1) > (Constants.StringPotLimits.babyPotMin + .02)) {
        if (Constants.LimitSwitch(0)) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2) > 0) {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
            }
            else {
                PapaArm.set(0);
            }
        }
        else if (Constants.LimitSwitch(1)) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2) < 0) {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
            }
            else {
                PapaArm.set(0);
            }
        }
        else {
            PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
        }
        }

        //Mama Arm Limits
        if (Constants.StringPot(1) > (Constants.StringPotLimits.babyPotMin + .02)) {
        if (Math.abs(Constants.SPDif(0, Constants.StringPotLimits.mamaPotMid)) < Constants.StringPotLimits.mamaHalfRange) {
            //if (Math.abs(Constants.SPDif(1, Constants.StringPotLimits.babyPotMin)) > .02) {
            MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
        }
        else if (Constants.SPDif(0, Constants.StringPotLimits.mamaPotMid) > Constants.StringPotLimits.mamaHalfRange) {
        //else if (Constants.SPDif(1,Constants.StringPotLimits.babyPotMin) > 0) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1) < 0 ) {
                MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
            }
            else {
                MamaArm.set(0);
            }
        }
        else if (Constants.SPDif(0, Constants.StringPotLimits.mamaPotMid) < -Constants.StringPotLimits.mamaHalfRange) {
        //else {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1) > 0 ) {
                MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
            }
            else {
                MamaArm.set(0);
            }
        }
        else {
            MamaArm.set(0); 
        }
        }
        else {
            MamaArm.set(0); 
        }

        //Baby Arm Limits
        if (Constants.StringPot(0) < (Constants.StringPotLimits.mamaPotMax - .04)) {
        if (Math.abs(Constants.SPDif(1, Constants.StringPotLimits.babyPotMid)) < Constants.StringPotLimits.babyHalfRange) {
        //if (Math.abs(Constants.SPDif(1, Constants.StringPotLimits.babyPotMin)) > .02) {
            BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
        }
        else if (Constants.SPDif(1, Constants.StringPotLimits.babyPotMid) > Constants.StringPotLimits.babyHalfRange) {
        //else if (Constants.SPDif(1,Constants.StringPotLimits.babyPotMin) > 0) {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1) < 0 ) {
                BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
            }
            else {
                BabyArm.set(0);
            }
        }
        else if (Constants.SPDif(1, Constants.StringPotLimits.babyPotMid) < -Constants.StringPotLimits.babyHalfRange) {
        //else {
            if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1) > 0 ) {
                BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
            }
            else {
                BabyArm.set(0);
            }
        }
        else {
            BabyArm.set(0); 
        }
        }

        //Wrist Limits 
        if (Math.abs(Constants.SPDif(2, Constants.StringPotLimits.wristPotMid)) < Constants.StringPotLimits.wristHalfRange) {
                Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0)*.5);
            }
            else if (Constants.SPDif(2, Constants.StringPotLimits.wristPotMid) > Constants.StringPotLimits.wristHalfRange) {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0) > 0 ) {
                    Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0)*.5);
                }
                else {
                    Wrist.set(0);
                }
            }
            else if (Constants.SPDif(2, Constants.StringPotLimits.wristPotMid) < -Constants.StringPotLimits.wristHalfRange) {
            //else {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0) < 0 ) {
                    Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0)*.5);
                }
                else {
                    Wrist.set(0);
                }
            }
            else {
                Wrist.set(0); 
            }
        
        //Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort, 0)*.5);
    }


    public static void motorStop() {
        MamaArm.set(0);
    }

    public static void runMotorLimitsV3() { //uses internal encoders
        
        
        if (Constants.neoRead(1) > (Constants.StringPotLimits.baMin + .02)) {
            if (Constants.LimitSwitch(0)) {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2) > 0) {
                    PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
                }
                else {
                    PapaArm.set(0);
                }
            }
            else if (Constants.LimitSwitch(1)) {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2) < 0) {
                    PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
                }
                else {
                    PapaArm.set(0);
                }
            }
            else {
                PapaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,2));
            }
            }
    
            //Mama Arm Limits
            if (Constants.neoRead(1) > (Constants.StringPotLimits.baMin + .02)) {
            if (Math.abs(Constants.neoDif(0, Constants.StringPotLimits.maMid)) < Constants.StringPotLimits.maHalfRange) {
                //if (Math.abs(Constants.neoDif(1, Constants.StringPotLimits.babyPotMin)) > .02) {
                MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
            }
            else if (Constants.neoDif(0, Constants.StringPotLimits.maMid) > Constants.StringPotLimits.maHalfRange) {
            //else if (Constants.neoDif(1,Constants.StringPotLimits.babyPotMin) > 0) {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1) < 0 ) {
                    MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
                }
                else {
                    MamaArm.set(0);
                }
            }
            else if (Constants.neoDif(0, Constants.StringPotLimits.maMid) < -Constants.StringPotLimits.maHalfRange) {
            //else {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1) > 0 ) {
                    MamaArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyTwoPort,1));
                }
                else {
                    MamaArm.set(0);
                }
            }
            else {
                MamaArm.set(0); 
            }
            }
            else {
                MamaArm.set(0); 
            }
    
            //Baby Arm Limits
            if (Constants.neoRead(0) < (Constants.StringPotLimits.maMax - .04)) {
            if (Math.abs(Constants.neoDif(1, Constants.StringPotLimits.baMid)) < Constants.StringPotLimits.baHalfRange) {
            //if (Math.abs(Constants.neoDif(1, Constants.StringPotLimits.babyPotMin)) > .02) {
                BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
            }
            else if (Constants.neoDif(1, Constants.StringPotLimits.baMid) > Constants.StringPotLimits.baHalfRange) {
            //else if (Constants.neoDif(1,Constants.StringPotLimits.babyPotMin) > 0) {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1) < 0 ) {
                    BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
                }
                else {
                    BabyArm.set(0);
                }
            }
            else if (Constants.neoDif(1, Constants.StringPotLimits.baMid) < -Constants.StringPotLimits.babyHalfRange) {
            //else {
                if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1) > 0 ) {
                    BabyArm.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,1));
                }
                else {
                    BabyArm.set(0);
                }
            }
            else {
                BabyArm.set(0); 
            }
            }
    
            //Wrist Limits 
            if (Math.abs(Constants.SPDif(2, Constants.StringPotLimits.wristPotMid)) < Constants.StringPotLimits.wristHalfRange) {
                    Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0)*.5);
                }
                else if (Constants.SPDif(2, Constants.StringPotLimits.wristPotMid) > Constants.StringPotLimits.wristHalfRange) {
                    if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0) > 0 ) {
                        Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0)*.5);
                    }
                    else {
                        Wrist.set(0);
                    }
                }
                else if (Constants.SPDif(2, Constants.StringPotLimits.wristPotMid) < -Constants.StringPotLimits.wristHalfRange) {
                //else {
                    if (RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0) < 0 ) {
                        Wrist.set(RobotContainer.sendAxisValue(Constants.OperatorConstants.kArmJoyOnePort,0)*.5);
                    }
                    else {
                        Wrist.set(0);
                    }
                }
                else {
                    Wrist.set(0); 
                }
            
    }

    public static double mamaNeoRead() {
        return MamaArm.getEncoder().getPosition()*-1;
    }
    public static double babyNeoRead() {
        return BabyArm.getEncoder().getPosition()*-1;
    }
}
