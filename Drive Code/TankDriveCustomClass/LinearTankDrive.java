package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class LinearTankDrive {

    private SpeedControllerGroup rightDriveTrain;
    private SpeedControllerGroup leftDriveTrain;
    private Joystick RStick;
    private Joystick LStick;

    public LinearTankDrive (SpeedController FR, SpeedController FL, SpeedController BR, SpeedController BL, Joystick RStick, Joystick LStick) {
        rightDriveTrain = new SpeedControllerGroup(FR,BR);
        leftDriveTrain = new SpeedControllerGroup(FL,BL);
        this.RStick = RStick;
        this.LStick = LStick;
    }

    public LinearTankDrive (SpeedControllerGroup rightDriveTrain, SpeedControllerGroup leftDriveTrain, Joystick RStick, Joystick LStick) {
        this.rightDriveTrain = rightDriveTrain;
        this.leftDriveTrain = leftDriveTrain;
        this.RStick = RStick;
        this.LStick = LStick;
    }

    public void drive () {

        //Right Side

        if (RStick.getY() > 0) {
            //forward half speed
            rightDriveTrain.set(0.5);
        }
        else if (RStick.getY() < 0) {
            //backwards half speed
            rightDriveTrain.set(0.5);
        }
        else {
            //stop
            rightDriveTrain.stopMotor();
        }


        //Left Side

        if (LStick.getY() > 0) {
            //forward half speed
            leftDriveTrain.set(0.5);
        }
        else if (LStick.getY() < 0) {
            //backward half speed
            leftDriveTrain.set(0.5);
        }
        else {
            //stop
            leftDriveTrain.stopMotor();
        }
    }
}
