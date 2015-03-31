package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;
import com.frc2879.eva.commands.ArcadeDrive;

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
		leftTalon.set(0);
		rightTalon.set(0);
		
		
		robotDrive = new RobotDrive(leftTalon, rightTalon);
		robotDrive.setSafetyEnabled(false);
	}
	
	public RobotDrive getRobotDrive() {
		return this.robotDrive;
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

