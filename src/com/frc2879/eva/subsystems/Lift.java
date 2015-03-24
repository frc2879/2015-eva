package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;
import com.frc2879.eva.commands.MoveLift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	final CANTalon motor1;
	final CANTalon motor2;
	
	public Lift(){
		
		motor1 = new CANTalon(RobotMap.CANDevices.LiftMotor1);
		motor2 = new CANTalon(RobotMap.CANDevices.LiftMotor2);
		
	}
	
	public void set(double outputValue) {
		motor1.set(outputValue);
		motor2.set(outputValue);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveLift());
    }
}

