/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public MecanumDrive m_robotDrive;
  private SpeedController frontLeftMotor = new Talon(RobotMap.Front_Left_Motor);
  private SpeedController rearLeftMotor = new Talon(RobotMap.Rear_Left_Motor);
  private SpeedController frontRightMotor = new Talon(RobotMap.Front_Right_Motor);
  private SpeedController rearRightMotor = new Talon(RobotMap.Rear_Right_Motor);

  public DriveTrain(){
  m_robotDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
  }

  public void jdrive(Joystick joy, Joystick aux) {
    m_robotDrive.driveCartesian(joy.getX(), joy.getY(), aux.getX());
  }
  public void drive(double x, double y, double zRotation) {
    m_robotDrive.driveCartesian(x, y, zRotation);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
