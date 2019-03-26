/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
// import edu.wpi.first.wpilibj.SpeedController;
// import edu.wpi.first.wpilibj.Talon;
// import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveCommand;;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  /*private static final double Kp = .3;//Placeholder Values
  private static final double Ki = 0;// PlaceHolder Value
  private static final double Kd = 0;// Placeholder Value
  private static final double Kf = 0;// Placeholder Value*/

  public MecanumDrive m_robotDrive;
  private VictorSP frontLeftMotor = new VictorSP(RobotMap.Front_Left_Motor);
  private VictorSP rearLeftMotor = new VictorSP(RobotMap.Rear_Left_Motor);
  private VictorSP frontRightMotor = new VictorSP(RobotMap.Front_Right_Motor);
  private VictorSP rearRightMotor = new VictorSP(RobotMap.Rear_Right_Motor);
  // private double kUpdatePeriod = 0.005; 

  Encoder m_LF_encoder = new Encoder(RobotMap.LF_EncoderA, RobotMap.LF_EncoderB, false, Encoder.EncodingType.k4X);
  Encoder m_RF_encoder = new Encoder(RobotMap.RF_EncoderA, RobotMap.RF_EncoderB, false, Encoder.EncodingType.k4X);
  Encoder m_LB_encoder = new Encoder(RobotMap.LB_EncoderA, RobotMap.LB_EncoderB, false, Encoder.EncodingType.k4X);
  Encoder m_RB_encoder = new Encoder(RobotMap.RB_EncoderA, RobotMap.RB_EncoderB, false, Encoder.EncodingType.k4X);

  PIDController m_LF_Controller;
  PIDController m_LB_Controller;
  PIDController m_RF_Controller;
  PIDController m_RB_Controller;



  public DriveTrain(){
  m_robotDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
  // m_robotDrive.setSafetyEnabled(false);
  m_LF_encoder.setDistancePerPulse(2*3*3.14/360/4);
  m_RF_encoder.setDistancePerPulse(2*3*3.14/360/4);
  m_LB_encoder.setDistancePerPulse(2*3*3.14/360/4);
  m_RB_encoder.setDistancePerPulse(2*3*3.14/360/4);
  
  m_LB_encoder.setSamplesToAverage(100);
  m_LF_encoder.setSamplesToAverage(100);
  m_RB_encoder.setSamplesToAverage(100);
  m_RF_encoder.setSamplesToAverage(100);

  // m_LF_encoder.start();
  m_LF_encoder.reset();
  // m_LB_encoder.start();
  m_LB_encoder.reset();
  // m_RF_encoder.start();
  m_RF_encoder.reset();
  // m_RB_encoder.start();
  m_RB_encoder.reset();

  // m_LF_Controller = new PIDController(Kp, Ki, Kd, Kf, m_LF_encoder, frontLeftMotor);
  // m_RF_Controller = new PIDController(Kp, Ki, Kd, Kf, m_RF_encoder, frontRightMotor);
  // m_LB_Controller = new PIDController(Kp, Ki, Kd, Kf, m_LB_encoder, rearLeftMotor);
  // m_RB_Controller = new PIDController(Kp, Ki, Kd, Kf, m_RB_encoder, rearRightMotor);

}

  public void jdrive(Joystick joy, Joystick aux) {
    m_robotDrive.driveCartesian(joy.getX(), -joy.getY(), -aux.getX());
    // while(m_LF_encoder.getDistance() < 2) {
    //   SmartDashboard.putNumber("Encoder Distance",m_LF_encoder.getDistance());
    //   SmartDashboard.putNumber("Encoder Distance",m_RF_encoder.getDistance());
    //   SmartDashboard.putNumber("Encoder Distance",m_LB_encoder.getDistance());
    //   SmartDashboard.putNumber("Encoder Distance",m_RB_encoder.getDistance());
    //   // prints displacement in revolutions
    //   SmartDashboard.putNumber("Encoder Rate",m_LF_encoder.getRate());
    //   SmartDashboard.putNumber("Encoder Rate",m_RF_encoder.getRate());
    //   SmartDashboard.putNumber("Encoder Rate",m_LB_encoder.getRate());
    //   SmartDashboard.putNumber("Encoder Rate",m_RB_encoder.getRate());
    //   // prints rate in Revs per second 
    //   Timer.delay(kUpdatePeriod);
    // }
  }
  public void drive(double x, double y, double zRotation) {
    m_robotDrive.driveCartesian(x, -y, zRotation);
  }

  public double getDistance(){
    return m_LF_encoder.getDistance();
  }

  public void resetDriveEncoders(){
    m_LF_encoder.reset();
    m_RF_encoder.reset();
    m_LB_encoder.reset();
    m_RB_encoder.reset();
  }

  public void stop(){
    this.drive(0, 0, 0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArcadeDriveCommand(Robot.m_drivetrain, Robot.m_oi.getMainJoystick(), Robot.m_oi.getAuxJoystick()));
  }
}
