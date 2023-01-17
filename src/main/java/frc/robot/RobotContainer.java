// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//Hi Julie Does this work? hmm

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmPrimary;
import frc.robot.commands.ArmRotate;
import frc.robot.commands.ArmSecondary;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ArmPrimarySub;
import frc.robot.subsystems.ArmRotateSub;
import frc.robot.subsystems.ArmSecondarySub;
import frc.robot.commands.Drive;
import frc.robot.commands.EncoderDrive;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ArmPrimarySub m_ArmPrimarySub = new ArmPrimarySub();
  private final ArmSecondarySub m_ArmSecondarySub = new ArmSecondarySub();
  private final ArmRotateSub m_ArmRotateSub = new ArmRotateSub();
  private final DriveTrain m_robotTrain = new DriveTrain();

  //public static final EncoderDrive encoderDrive = new EncoderDrive(0, 0);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final static CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  public final static Joystick m_ArmOneJoy = new Joystick(OperatorConstants.kOperatorJoystickLeft);
  public final static Joystick m_ArmTwoJoy = new Joystick(OperatorConstants.kOperatorJoystickRight); 

  

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    //m_ArmPrimarySub.setDefaultCommand(new ArmPrimary(m_ArmPrimarySub,m_driverController.getRawAxis(1)));
    m_ArmSecondarySub.setDefaultCommand(new ArmSecondary(m_ArmSecondarySub,m_driverController.getRawAxis(5)));
    m_ArmRotateSub.setDefaultCommand(new ArmRotate(m_ArmRotateSub,m_driverController.getRawAxis(4)));

    
    m_ArmPrimarySub.setDefaultCommand(new ArmPrimary(m_ArmPrimarySub,m_ArmOneJoy.getRawAxis(1)));
    //m_ArmSecondarySub.setDefaultCommand(new ArmSecondary(m_ArmSecondarySub,m_ArmTwoJoy.getRawAxis(1)));
    //m_ArmRotateSub.setDefaultCommand(new ArmRotate(m_ArmRotateSub,m_ArmTwoJoy.getRawAxis(2)));
    

    m_robotTrain.setDefaultCommand(new Drive(m_robotTrain));
    
    
    
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    //m_driverController.a().whileTrue(new ArmPrimary(m_ArmPrimarySub,m_driverController.getRawAxis(2)));

    //m_driverController.x().whileTrue(new ArmSecondary(m_ArmSecondarySub,m_driverController.getRawAxis(3)));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
