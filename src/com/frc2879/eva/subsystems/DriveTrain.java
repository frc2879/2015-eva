package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;
import com.frc2879.eva.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	final RobotDrive robotDrive;
	
	final CANTalon leftTalon;
	final CANTalon rightTalon;
	
	public DriveTrain(){
		
		leftTalon = new CANTalon(RobotMap.CANDevices.leftDrive);
		rightTalon = new CANTalon(RobotMap.CANDevices.rightDrive);
		
		robotDrive = new RobotDrive(leftTalon, rightTalon);
	}
	
	public RobotDrive getRobotDrive() {
		return this.robotDrive;
	}
	
	public void arcadeDrive(Joystick stick, boolean squaredInputs) {
		robotDrive.arcadeDrive(stick, squaredInputs);
	}
	public void arcadeDrive(Joystick moveStick, int moveAxis, Joystick rotateStick, int rotateAxis, boolean squaredInputs) {
		robotDrive.arcadeDrive(moveStick, moveAxis, rotateStick, rotateAxis, squaredInputs);
	}
	
	public void drive(double outputMagnitude, double curve) {
        robotDrive.drive(outputMagnitude, curve);
    }
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    	
    	
    }
    
    public void stop() {
    	robotDrive.stopMotor();
    }
    
    
}

