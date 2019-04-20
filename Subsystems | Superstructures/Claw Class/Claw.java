public class Claw {
    
    private SpeedController RHandMotor;
    private SpeedController LHandMotor;

    private SpeedController RFingerMotor;
    private SpeedController LFingerMotor;

    public boolean isClawOpen;
    public boolean isPinchOpen;


    public Claw (SpeedController RHandMotor, SpeedController LHandMotor) {
        
        this.RHandMotor = RHandMotor;
        this.LHandMotor = LHandMotor;

        this.RFingerMotor = RHandMotor;
        this.LFingerMotor = LHandMotor;

        this.isClawOpen = true;
        this.isPinchOpen = null;

    }


    public Claw (SpeedController RHandMotor, SpeedController LHandMotor, SpeedController RFingerMotor, SpeedController LFingerMotor) {
        
        this.RHandMotor = RHandMotor;
        this.LHandMotor = LHandMotor;

        this.RFingerMotor = RFingerMotor;
        this.LFingerMotor = LFingerMotor;

        this.isClawOpen = true;
        this.isPinchOpen = true;

    }


    public Claw (SpeedController RHandMotor, SpeedController LHandMotor, SpeedController RFingerMotor, SpeedController LFingerMotor, boolean isClawOpen, boolean isPinchOpen) {
        
        this.RHandMotor = RHandMotor;
        this.LHandMotor = LHandMotor;

        this.RFingerMotor = RFingerMotor;
        this.LFingerMotor = LFingerMotor;

        this.isClawOpen = isClawOpen;
        this.isPinchOpen = isPinchOpen;
        
    }


    public void openClaw () {

        if (!isClawOpen()) {
            RHandMotor.set(-0.5);
            LHandMotor.set(0.5);
            isClawOpen = true;
        }
        else {
            closeClaw();
        }

    }

    public void closeClaw () {

        if (isClawOpen()) {
            RHandMotor.set(0.5);
            LHandMotor.set(-0.5);
            isClawOpen = false;
        }
        else {
            openClaw();
        }

    }


    public void stopClaw () {

        RHandMotor.stopMotor();
        LHandMotor.stopMotor();
    }


    public void openPinch () {

        if (!isPinchOpen()) {
            RFingerMotor.set(0.5);
            LFingerMotor.set(-0.5);
            isPinchOpen = open;
        }
        else {
            closePinch();
        }

    }

    public void closePinch () {

        if (isPinchOpen()) {
            RFingerMotor.set(-0.5);
            LFingerMotor.set(0.5);
            isPinchOpen = false;
        }
        else {
            openPinch();
        }

    }

    public void stopPinch() {

        RFingerMotor.stopMotor();
        LFingerMotor.stopMotor();

    }


    public void stop () {

        stopClaw();
        stopPinch();

    }

}
