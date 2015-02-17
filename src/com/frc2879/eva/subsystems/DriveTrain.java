package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;
import com.frc2879.eva.commands.drive.ArcadeDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
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
	
	public void arcadeDrive(Joystick stick, boolean squaredInputs) {
		robotDrive.arcadeDrive(stick, squaredInputs);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    	
    	
    }
}

