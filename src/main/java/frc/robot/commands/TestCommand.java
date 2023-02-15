// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TestSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

//When called, makes a motor run forward or backward
public class TestCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TestSub m_talon;
  double talon_speed;
  boolean direction;


  public TestCommand(TestSub incomingMotor, double speed, boolean direction) {
    m_talon = incomingMotor;
    talon_speed = speed;

    //addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (direction) {
        TestSub.m_talon.set(talon_speed); //forward
    }
    else {
        TestSub.m_talon.set(-talon_speed); //backward
    }
    TestSub.m_talon.feed();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}