package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
  
  //Declare your joystick(s), the argument is the USB port the stick is plugged into
  
  private final Joystick buttonStick = new Joystick(1);
  private final Joystick driveStick = new Joystick(2);
  
  
  //Declare the buttons, the argument is the number of the button on the joystick (usually physically labeled)
  
  private final JoystickButton exampleButton = new JoystickButton(12);
  
  
  //See "Drive Code" for details on setting up the drive train
  
  private final SpeedController driveMotorFR = new SpeedController(0);
  private final SpeedController driveMotorFL = new SpeedController(1);
  private final SpeedController driveMotorBR = new SpeedController(2);
  private final SpeedController driveMotorBL = new SpeedController(3);
  
  private final SpeedControllerGroup rightDriveTrain = new SpeedControllerGroup(driveMotorFR,driveMotorBR);
  private final SpeedControllerGroup leftDriveTrain = new SpeedControllerGroup(driveMotorFL,driveMotorBL);
  
  private final DifferentialDrive driveTrain = new DifferentialDrive(rightDriveTrain,leftDriveTrain,driveStick);
  

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
    
    driveTrain.arcadeDrive(driveStick.getY(),driveStick.getX());
    
  }


  @Override
  public void testPeriodic() {
  }
}
