/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HatchRS;
import frc.robot.commands.LauncherRS;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick joy = new Joystick(1); // Drive Joystick

	//Drive Stick Button Mapping
	JoystickButton button1 = new JoystickButton(joy, 1);
	JoystickButton button2 = new JoystickButton(joy, 2);
	JoystickButton button3 = new JoystickButton(joy, 3);
	JoystickButton button4 = new JoystickButton(joy, 4);
	JoystickButton button5 = new JoystickButton(joy, 5);
	JoystickButton button6 = new JoystickButton(joy, 6);
	JoystickButton button7 = new JoystickButton(joy, 7);
	JoystickButton button8 = new JoystickButton(joy, 8);
	JoystickButton button9 = new JoystickButton(joy, 9);
	JoystickButton button10 = new JoystickButton(joy, 10);
	JoystickButton button11 = new JoystickButton(joy, 11);
	public static int axisX = 0;
	public static int axisY = 1;
	public static int axisZ = 2;

	public static Joystick aux = new Joystick(0); // Auxilary Joystick

	//Auxilary Stick Button Mapping
	JoystickButton buttonAux1 = new JoystickButton(aux, 1);
	JoystickButton buttonAux2 = new JoystickButton(aux, 2);
	JoystickButton buttonAux3 = new JoystickButton(aux, 3);
	JoystickButton buttonAux4 = new JoystickButton(aux, 4);
	JoystickButton buttonAux5 = new JoystickButton(aux, 5);
	JoystickButton buttonAux6 = new JoystickButton(aux, 6);
	JoystickButton buttonAux7 = new JoystickButton(aux, 7);
	JoystickButton buttonAux8 = new JoystickButton(aux, 8);
	JoystickButton buttonAux9 = new JoystickButton(aux, 9);
	JoystickButton buttonAux10 = new JoystickButton(aux, 10);
	JoystickButton buttonAux11 = new JoystickButton(aux, 11);
	public static int axisAuxX = 0;
	public static int axisAuxY = 1;
  	public static int axisAuxZ = 2;

  public OI(){
	button2.whileHeld(new HatchRS(true));
	button2.whenReleased(new HatchRS(false));
	buttonAux1.whenPressed(new LauncherRS(false));
	buttonAux2.whenPressed(new LauncherRS(true));
  }

  public Joystick getJoystick(){
    return joy;
  }

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
