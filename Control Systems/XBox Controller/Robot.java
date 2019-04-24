package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
  
  //Declare XBox Controller, argument is the USB port on the drive station that the controller is connected to
  
  private final XBoxController controller = new XBoxController(1);
  
  
  //See "Drive Code" for more details on setting up the drive train
  private final SpeedController driveMotorFR = new SpeedController(0);
  private final SpeedController driveMotorFL = new SpeedController(1);
  private final SpeedController driveMotorBR = new SpeedController(2);
  private final SpeedController driveMotorBL = new SpeedController(3);
  
  private final SpeedControllerGroup rightDriveTrain = new SpeedControllerGroup(driveMotorFR,driveMotorBR);
  private final SpeedControllerGroup leftDriveTrain = new SpeedControllerGroup(driveMotorFL,driveMotorBL);
  
  private final DifferentialDrive driveTrain = new DifferentialDrive(lefttDriveTrain,rightDriveTrain);
  

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
    
    //To get the positions of a joystick on the controller, you must tell it what hand / side of the controller
    
    driveTrain.arcadeDrive(controller.getY(kRight), controller.getX(kRight));
    
  }


  @Override
  public void testPeriodic() {
  }
}
