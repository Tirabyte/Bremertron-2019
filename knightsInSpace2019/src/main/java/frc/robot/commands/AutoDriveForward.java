/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;

public class AutoDriveForward extends Command {

  private double m_distance;
  private static DriveTrain m_DriveTrain;
  public AutoDriveForward(double distance) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    m_distance = distance;
    requires(m_DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_DriveTrain.resetDriveEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    while(m_DriveTrain.getDistance() != m_distance){
      m_DriveTrain.drive(0.5, 0, 0);
    }
    isFinished();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    m_DriveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    m_DriveTrain.stop();
  }
}
