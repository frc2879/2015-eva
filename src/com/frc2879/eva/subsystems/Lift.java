package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;
import com.frc2879.eva.commands.MoveLift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	final CANTalon motor1;
	final CANTalon motor2;
	
	Solenoid brakeSol;
	
	public Lift(){
		
		motor1 = new CANTalon(RobotMap.CANDevices.LiftMotor1);
		motor2 = new CANTalon(RobotMap.CANDevices.LiftMotor2);
		
		motor2.changeControlMode(ControlMode.Follower);
		motor2.set(motor1.getDeviceID());
		
		//TODO motorX.setVoltageRampRate(x); x represents 0 to x volts in 1 second
		
		brakeSol = new Solenoid(RobotMap.PCM.PCM_CAN, RobotMap.PCM.BrakeSol);
		
	}
	
	public void releaseBrake(){
		brakeSol.set(false);
	}
	
	public void engageBrake(){
		brakeSol.set(true);
	}
	
	public void set(double outputValue) {
		motor1.set(outputValue);
	}


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveLift());
    }
    
    public void stop() {
    	motor1.stopMotor();
    	motor2.stopMotor();
    	engageBrake();
    }
}

