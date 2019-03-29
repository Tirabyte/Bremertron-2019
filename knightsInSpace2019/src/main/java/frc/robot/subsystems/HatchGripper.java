/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchGripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double m_speed = 0.5;
  private double m_delayRelease = 1;
  private double m_delayGrab = 1;
  // private static Talon m_IntakeMotor = new Talon(RobotMap.Panel_Intake_Motor);

  private static Solenoid m_panelExtender = new Solenoid(RobotMap.Hatch_Piston);
  public static Solenoid m_clawSolenoid = new Solenoid(RobotMap.Hatch_VacuumBreak);

  public void gripPanel(boolean direction){
    if(direction){
      m_clawSolenoid.set(false);
      // m_IntakeMotor.set(m_speed);
      System.out.println("Opening Claw");
      // Timer.delay(m_delayGrab);
      // m_IntakeMotor.set(0);
    }else if(!direction){
      m_clawSolenoid.set(true);
      // m_IntakeMotor.set(0);
      System.out.println("Closing Claw");
      // Timer.delay(m_delayRelease);
      // m_vacuumBreakSolenoid.set(false);
    }else {
      System.out.println("Invalid Input: HatchGripper.gripPanel method");
    }
  }

  public void extendPiston(boolean extended){
    m_panelExtender.set(extended);
    /* if(extended){
      m_panelExtender.set(Value.kForward);
     }else {
      m_panelExtender.set(Value.kReverse);
     }*/
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
