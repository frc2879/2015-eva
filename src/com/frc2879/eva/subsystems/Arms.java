package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid sol;
	
	public Arms() {
		sol = new DoubleSolenoid(RobotMap.PCM.PCM_CAN, RobotMap.PCM.ArmsSolF, RobotMap.PCM.ArmsSolR);
	}
	
	public DoubleSolenoid getSol() {
		return sol;
	}
	
	public void solOff() {
		sol.set(DoubleSolenoid.Value.kOff);
	}
	
	public void solForward() {
		sol.set(DoubleSolenoid.Value.kForward);
	}
	
	public void solReverse() {
		sol.set(DoubleSolenoid.Value.kReverse);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

