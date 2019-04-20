package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//

private final SpeedController RHandMotor = new SpeedController(0);
private final SpeedController LHandMotor = new SpeedController(1);

private final SpeedController RFingerMotor = new SpeedController(2);
private final SpeedController LFingerMotor = new SpeedController(3);


//Declare the Claw object, arguments are the two "hand" SpeedControllers
private final Claw simpleClaw = new Claw(RHandMotor,LHandMotor);

//If your claw is articulating, then declar an ArticulateClaw class with four SpeedControllers as the arguments
private final Claw articulateClaw = new Claw(RHandMotor,LHandMotor,RFingerMotor,LFingerMotor);


//Declare your Drive Station joystick or controller
private final Joystick clawStick = new Joystick(1);

//Declare your Joystick buttons, arguments are the joystick and the button number
private final JoystickButton clawButton = new JoystickButton(clawStick,1);

private final JoystickButton pinchButton = new JoystickButton(clawStick,2);

public class Robot extends IterativeRobot {

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
    
    //When the button is pressed the claw will either open or close depending on is current state
    
    if (clawButton.get()) {
      simpleClaw.openClaw();
    }
    else {
      simpleClaw.stopClaw();
    }
    
  }


  @Override
  public void testPeriodic() {
    
    if (clawButton.get()) {
      articulateClaw.openClaw();
    }
    else {
      articulateClaw.stopClaw();
    }
    
    if (pinchButton.get()) {
      artuclateClaw.openPinch();
    }
    else {
      articulateClaw.stopPunch();
    }
    
  }
}
