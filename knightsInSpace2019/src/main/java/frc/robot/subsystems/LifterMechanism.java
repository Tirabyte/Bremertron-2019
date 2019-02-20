/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LifterMechanism extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Solenoid ForePistons = new Solenoid(RobotMap.Front_Wheel_Pistons);
  public static Solenoid AftPistons = new Solenoid(RobotMap.Rear_Wheel_Pistons);
  public static AnalogInput ForwardSensor = new AnalogInput(RobotMap.Front_Height_Ultra);
  public static AnalogInput AftSensor = new AnalogInput(RobotMap.Rear_Height_Ultra);

  public void setPistonHeight(boolean height, Solenoid piston){
    piston.set(height);
  }

  public double getHeight(int sensor, double distance){
    double x;
    switch (sensor){
      case 0:
        x = ForwardSensor.getVoltage();
        distance = x/2;
        break;
      case 1:
        x = AftSensor.getVoltage();
        distance = x/2;
        break;
      default:
        System.out.println("Error: Invalid Input (Ultra getHeight)");
    }
    return distance;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
