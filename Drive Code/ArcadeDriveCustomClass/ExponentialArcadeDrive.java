package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ExponentialArcadeDrive {

    private SpeedControllerGroup rightDriveTrain;
    private SpeedControllerGroup leftDriveTrain;
    private Joystick driveStick;

     public ExponentialArcadeDrive (SpeedController FR, SpeedController FL, SpeedController BR, SpeedController BL, Joystick driveStick) {
        rightDriveTrain = new SpeedControllerGroup(FR,BR);
        leftDriveTrain = new SpeedControllerGroup(FL,BL);
        this.driveStick = driveStick;
    }

    public ExponentialArcadeDrive (SpeedControllerGroup rightDriveTrain, SpeedControllerGroup leftDriveTrain, Joystick driveStick) {
        this.rightDriveTrain = rightDriveTrain;
        this.leftDriveTrain = leftDriveTrain;
        this.driveStick = driveStick;
    }

    public void drive () {
        rightDriveTrain.set(driveStick.getY() + driveStick.getX());
        leftDriveTrain.set(-driveStick.getY() + driveStick.getX());
    }
    
    public void reverseDrive () {
        rightDriveTrain.set(-driveStick.getY() + driveStick.getX());
        leftDriveTrain.set(driveStick.getY() + driveStick.getX());
    }
}
