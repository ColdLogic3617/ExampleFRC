package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;
import java.util.Map;

public class MultiController {

    private ArrayList<GenericHID> controllerList = new ArrayList<GenericHID>();
    private int currentController = 0;

    private String[] buttonMap = {"","Trigger"}

    public MultiController (GenericHID[] controllerList) {
        for (GenericHID controller : controllerList) {
            this.controllerList.add(controller);
        }
    }


    public void useNextController() {
        currentController++;
        if (currentController >= controllerList.size()) {
            currentController = 0;
        }
    }

    public void usePreviousController() {
        currentController--;
        if (currentController <= 0) {
            currentController = controllerList.size()-1;
        }
    }


    public boolean getButtonPressed(int buttonNumber) {
        GenericHID controller = controllerList.get(currentController);
        if (controller instanceof XBoxController) {
            if (buttonNumber == 1) {
                return controller.getTriggerAxis(Hand.kRight);
            }
            if (buttonNumber == 2) {

            }
        }
    }

}
