package org.usfirst.frc.team5542.robot.commands.autonomous;

import org.usfirst.frc.team5542.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JustMove extends CommandBase {
	
	//long startTime;
	//int time = 4;

    public JustMove() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.reset();
    	//startTime = System.currentTimeMillis();
    	SmartDashboard.putNumber("Starting Value", drivetrain.getDistance());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.fprDrive(.5, 0);
    	SmartDashboard.putNumber("left", drivetrain.leftDistance());
    	SmartDashboard.putNumber("right", drivetrain.rightDistance());
    	SmartDashboard.putNumber("distance", drivetrain.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getDistance() > 72);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.fprDrive(0, 0);
    	SmartDashboard.putNumber("end left", drivetrain.leftDistance());
    	SmartDashboard.putNumber("end right", drivetrain.rightDistance());
    	SmartDashboard.putNumber("end distance", drivetrain.getDistance());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
