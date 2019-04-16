package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ExponentialTankDrive {

    private SpeedControllerGroup rightDriveTrain;
    private SpeedControllerGroup leftDriveTrain;
    private Joystick RStick;
    private Joystick LStick;

    public ExponentialTankDrive (SpeedController FR, SpeedController FL, SpeedController BR, SpeedController BL, Joystick RStick, Joystick LStick) {
        rightDriveTrain = new SpeedControllerGroup(FR,BR);
        leftDriveTrain = new SpeedControllerGroup(FL,BL);
        this.RStick = RStick;
        this.LStick = LStick;
    }

    public ExponentialTankDrive (SpeedControllerGroup rightDriveTrain, SpeedControllerGroup leftDriveTrain, Joystick RStick, Joystick LStick) {
        this.rightDriveTrain = rightDriveTrain;
        this.leftDriveTrain = leftDriveTrain;
        this.RStick = RStick;
        this.LStick = LStick;
    }

    public void drive () {
        rightDriveTrain.set(RStick.getY());
        leftDriveTrain.set(LStick.getY());
    }
}
