package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;
import com.frc2879.eva.commands.ArcadeDrive;
import com.frc2879.eva.input.XboxController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
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
		
		leftTalon = new CANTalon(RobotMap.CANDevices.LEFT_DRIVE);
		rightTalon = new CANTalon(RobotMap.CANDevices.RIGHT_DRIVE);
		
		leftTalon.changeControlMode(ControlMode.PercentVbus);
		rightTalon.changeControlMode(ControlMode.PercentVbus);
		
		leftTalon.setVoltageRampRate(12);
		rightTalon.setVoltageRampRate(12);
		
		leftTalon.enableBrakeMode(true);
		rightTalon.enableBrakeMode(true);
		
		//leftTalon.reverseOutput(false);
		//rightTalon.reverseOutput(false);
		
		leftTalon.set(0);
		rightTalon.set(0);
		
		robotDrive = new RobotDrive(leftTalon, rightTalon);
		robotDrive.setSafetyEnabled(false);
		
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft , true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight , true);
	}
	
	// Takes in a XboxController and drives the robot
	public void drive(XboxController controller) {
		robotDrive.arcadeDrive(-controller.leftStick.getY(),controller.rightStick.getX() , false);
	}
	
	// Autonomous, drives the robot at the rate forward
	// The rate is from 0 to 1.0
	public void driveForward(double rate) {
		// Keep from accidentally going backward
		if (rate < 0) {
			rate = 0;
		}
		
		robotDrive.arcadeDrive(-rate, 0, false);
	}
	
	// Autonomous, drives the robot backwards
	// The rate is from 0 to 1.0
	public void driveBackward(double rate) {
		// Keep from accidentally going forward
		if (rate < 0) {
			rate = 0;
		}
		
		robotDrive.arcadeDrive(rate, 0, false);
	}
	
	// Autonomous, stops the drive train
	public void stop() {
		robotDrive.stopMotor();
	}
	
	public RobotDrive getRobotDrive() {
		return this.robotDrive;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    	
    	
    }
}

