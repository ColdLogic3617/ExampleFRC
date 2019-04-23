/*
  Delcare the Compressor
    http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/Compressor.html
*/
Compressor c = new Compressor(0);

c.setClosedLoopControl(true);
c.setClosedLoopControl(false);

/* Declare the Solenoid
    http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/Solenoid.html
*/

Solenoid exampleSolenoid = new Solenoid(1);

exampleSolenoid.set(true);
exampleSolenoid.set(false);
