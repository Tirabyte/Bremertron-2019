/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDriveCommand extends Command {
  private DriveTrain m_drivetrain;
  private Joystick m_joystick;
  private Joystick m_auxstick;

  public ArcadeDriveCommand(DriveTrain drivetrain, Joystick joy, Joystick aux) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_drivetrain = drivetrain;
    m_joystick = joy;
    m_auxstick = aux;
    requires(m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_drivetrain.jdrive(m_joystick, m_auxstick);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    m_drivetrain.stop();
  }
}
