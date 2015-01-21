package org.usfirst.frc.team5542.robot.commands;

import org.usfirst.frc.team5542.robot.OI;
import org.usfirst.frc.team5542.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *Default tank-style drive control
 */
public class UserDrive extends CommandBase {

    public UserDrive() {
        requires(drivetrain);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick controller = Robot.oi.getController();
    	double left = controller.getRawAxis(OI.lyAxis);
    	double right = controller.getRawAxis(OI.ryAxis);
    	double arm = controller.getRawAxis(OI.dPad);
    	double strafe = controller.getRawAxis(OI.rTrigger) - controller.getRawAxis(OI.lTrigger);
    	if (left >= 0)
    		left = Math.pow(left, OI.sensitivity);
    	else
    		left = -(Math.pow(-left, OI.sensitivity));
    	if (right >= 0)
    		right = Math.pow(right, OI.sensitivity);
    	else
    		right = -(Math.pow(-right, OI.sensitivity));
    	if (strafe >= 0)
    		strafe = Math.pow(strafe, OI.sensitivity);
    	else
    		strafe = -(Math.pow(-strafe, OI.sensitivity));
    	if (left > -.05 && left < .05)
    		left = 0.0;
    	if (right > -.05 && right < .05)
    		right = 0.0;
    	if (strafe > -.05 && strafe < .05)
    		strafe = 0.0;
    	if (arm >= 0.0)
    		arm = Math.pow(arm, OI.sensitivity);
    	else
    		arm = -(Math.pow(-arm, OI.sensitivity));
    	drivetrain.arm(arm);
    	drivetrain.tankDrive(left, right);
    	drivetrain.strafe(strafe);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drivetrain.tankDrive(0, 0);
    	drivetrain.strafe(0);
    }
}
