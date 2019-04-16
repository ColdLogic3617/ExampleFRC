/*TANK DRIVE (also called DIFFERENTIAL DRIVE)
    DESCRIPTION:
      The robot uses two joysticks to control movement. Each joystick controls the forward and backward motion of one side of the robot.
      To turn, push one stick forward and the other one back.
    VARIATIONS:
      Linear - if the stick is being pressed forward then the motors go at a constant speed in that direction.
      Exponential - the motor speed is directly related to how far the stick is pushed/pulled.
*/

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

  //Declare each motor controller as the type of controller (Victor, Spark, etc.), the argument is the connected PWM port on the RoboRIO
  
  private final SpeedController driveMotorFR = new SpeedController(0);
  private final SpeedController driveMotorFL = new SpeedController(1);
  private final SpeedController driveMotorBR = new SpeedController(2);
  private final SpeedController driveMotorBL = new SpeedController(3);

  //Speed Controller can be grouped

  private final SpeedControllerGroup rightDriveTrain = new SpeedControllerGroup(driveMotorFR,driveMotorBR);
  private final SpeedControllerGroup leftDriveTrain = new SpeedControllerGroup(driveMotorFL,driveMotorBL);


  //Declare each joystick, the argument is the connected USB port on the drive station computer
  
  private final Joystick RStick = new Joystick(0);
  private final Joystick LStick = new Joystick(1);


  //Declare the tank drive objects. They can take either a Speed Controller Group or the individual Speed Controllers, plus the two joysticks
  private final LinearTankDrive = new LinearTankDrive(rightDriveTrain,leftDriveTrain,RStick,LStick);
  private final ExponentialTankDrive = new ExponentialTankDrive(rightDriveTrain,leftDriveTrain,RStick,LStick);


  @Override
  public void robotInit() {
  }


  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
  }


  @Override
  public void autonomousPeriodic() {
  }


  @Override
  public void teleopPeriodic() {
      ExponentialTankDrive.drive();
  }


  @Override
  public void testPeriodic() {
      LinearTankDrive.drive();
  }
}
