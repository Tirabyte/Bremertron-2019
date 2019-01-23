/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private double kUpdatePeriod = 0.005; 

  Encoder leftSide = new Encoder(1, 2, false, Encoder.EncodingType.k4X);

  public DriveTrain(){
  m_robotDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
  }

  public void jdrive(Joystick joy, Joystick aux) {
    m_robotDrive.driveCartesian(joy.getX(), joy.getY(), aux.getX());
    while(leftSide.getDistance() < 2) {
      SmartDashboard.putNumber("Encoder Distance",leftSide.getDistance());
      // prints displacement in revolutions
      SmartDashboard.putNumber("Encoder Rate",leftSide.getRate());
      // prints rate in Revs per second 
      Timer.delay(kUpdatePeriod);
    }
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
