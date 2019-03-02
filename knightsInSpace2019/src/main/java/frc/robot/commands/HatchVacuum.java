/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HatchGripper;

public class HatchVacuum extends Command {
  private boolean m_direction;
  private HatchGripper m_gripper = Robot.m_gripper;
  private boolean m_finished = false;
  public HatchVacuum(boolean direction) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_direction = direction;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Starting Hatch Vacuum Command");
    m_gripper.gripPanel(m_direction);
    m_finished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return m_finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Hatch Vacuum Command ");
    m_finished = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
