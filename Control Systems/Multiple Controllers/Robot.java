package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import MultiController.java;


public class Robot extends IterativeRobot {

    private final Joystick driveStick = new Joystick(1);
    private final XBoxController controller = new XBoxController(2);

    //Declare the MultiController class, the argument is an array of GenericHID controllers

    private final MultiController controller = new MultiController(GenericHID[]{driveStick,controller});


    private final DifferentialDrive driveTrain = new DifferentialDrive(new SpeedControllerGroup(new SpeedController(0),new SpeedController(2)), new SpeedControllerGroup(new SpeedController(1), new SpeedController(3)));


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

    if (controller.getStartButton()) {
        controller.useNextController();
    }

    driveTrain.arcadeDrive(controller.getY(), controller.getX());

  }


  @Override
  public void testPeriodic() {
  }
}
