/*ARCADE DRIVE
    DESCRIPTION:
      
    VARIATIONS:
      Linear - 
      Exponential - 
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
    
  //Motor controllers can be grouped using a SpeedControllerGroup object
  
  private final SpeedControllerGroup leftDriveTrain = new SpeedControllerGroup(driveMotorFL,driveMotorBL);
  private final SpeedControllerGroup rightDriveTrain = new SpeedControllerGroup(driveMotorFR,driveMotorBR);


  //Declare each joystick, the argument is the connected USB port on the drive station computer
  
  private final Joystick RStick = new Joystick(0);
  private final Joystick LStick = new Joystick(1);


  //Declare the Differential Drive object, requires 2 Speed Controller Groups - left then right
  private final DifferentialDrive driveTrain = new DifferentialDrive(leftDriveTrain,rightDriveTrain);


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
      
      //Differential Drive Object, arguments are speed and rotation
        //You can also set the SquareInputs flag if using a directional pad (add a third arguement of true)
      
      driveTrain.arcadeDrive(RStick.getY(), RStick.getX());
  }


  @Override
  public void teleopPeriodic() {

      //Exponential Arcade Drive

      leftDriveTrain.set(RStick.getY() + RStick.getX());
      rightDriveTrain.set(-RStick.getY() + RStick.getX());
  }


  @Override
  public void testPeriodic() {
      
      //Linear Arcade Drive
      
      if (RStick.getY() > 0) {
          //Forward, half speed
          leftDriveTrain.set(0.5);
          rightDriveTrain.set(0.5);
      }
      else if (RStick.getX() > 0) {
          //Turn right, half speed
          leftDriveTrain.set(0.5);
          rightDriveTrain.set(-0.5);
      }
      else if (RStick.getX() < 0) {
          //Turn left, half speed
          leftDriveTrain.set(-0.5);
          rightDriveTrain.set(0.5);
      }
      else if (RStick.getY() < 0) {
          //Backward, half speed
          leftDriveTrain.set(-0.5);
          rightDriveTrain.set(-0.5);
      }
      else {
          leftDriveTrain.stopMotor();
          rightDriveTrain.stopMotor();
      }
  }
}
