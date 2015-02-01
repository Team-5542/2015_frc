package org.usfirst.frc.team5542.robot.subsystems;

import org.usfirst.frc.team5542.robot.RobotMap;
import org.usfirst.frc.team5542.robot.commands.UserCamera;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Motors for camera motion.
 */
public class Camera extends Subsystem {

	private Servo tiltMotor;
	private Servo panMotor;
	private final double rate = .025;
	private CameraServer video;
	private Camera(){
		tiltMotor = new Servo(RobotMap.tiltMotor);
		panMotor = new Servo(RobotMap.panMotor);
		video = CameraServer.getInstance();
	}
	
	
	
    	public void tilt(boolean input){
    		double tilt = tiltMotor.get();
    		if (input == true){
    			tilt = tilt + rate;
    			if (tilt >= 1)
    				tilt = 1;
    		}
    		else{
    			tilt = tilt - rate;
    			if (tilt <= 0)
    				tilt = 0;
    		}
    		tiltMotor.set(tilt);
	}
    
    
    	public void pan(boolean input){
    		double pan = panMotor.get();
    		if (input == true){
    			pan = pan + rate;
    			if (pan >= 1)
    				pan = 1;
    		}
    		else{
    			pan = pan - rate;
    			if (pan <= 0)
    				pan = 0;
    		}
    		panMotor.set(pan);
    	}
    	
    	public void setTilt(double input){
    		tiltMotor.set(input);
    	}
    	
    	public double getTilt(){
    		return tiltMotor.get();
    	}
    	
    	public double getPan(){
    		return panMotor.get();
    	}
    	
    	public void setPan(double input){
    		panMotor.set(input);
    	}
    	
    	
    	
    	private static Camera instance;
    	
    	public static Camera getInstance(){
    		if (instance == null)
    			instance = new Camera();
    		return instance;
    	}
    	
    	public void startVideoFeed(){
    		video.startAutomaticCapture();
    	}

    public void initDefaultCommand() {
        setDefaultCommand(new UserCamera());
    }
}
