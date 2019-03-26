/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LifterMechanism;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;

public class SetPistonHeight extends Command {
   private LifterMechanism m_lifter;
   private boolean m_height;
   private DoubleSolenoid m_piston;
   private boolean m_finished;
   
   public SetPistonHeight(boolean i, DoubleSolenoid piston) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    //requires(Robot.m_lifter);
    m_lifter = Robot.m_lifter;
    m_height = i;
    m_piston = piston;
    m_finished = false;
  }
 
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_lifter.setPistonHeight(m_height, m_piston);
    //Timer.delay(4);  // delay to weight for piston to reach extension NEED ACTUAL TIME
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
