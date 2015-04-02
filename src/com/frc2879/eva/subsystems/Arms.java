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
	
	DoubleSolenoid leftSol;
	DoubleSolenoid rightSol;
	
	public boolean grabbed;
	
	public Arms() {
		leftSol = new DoubleSolenoid(RobotMap.PCM.PCM_CAN, RobotMap.PCM.LEFT_ARM_SOL_F, RobotMap.PCM.LEFT_ARM_SOL_R);
		rightSol = new DoubleSolenoid(RobotMap.PCM.PCM_CAN, RobotMap.PCM.RIGHT_ARM_SOL_F, RobotMap.PCM.RIGHT_ARM_SOL_R);
	}
	
	public DoubleSolenoid getLeftSol() {
		return leftSol;
	}
	
	public DoubleSolenoid getRightSol() {
		return rightSol;
	}
	
	public void setBoth(DoubleSolenoid.Value lval, DoubleSolenoid.Value rval) {
		leftSol.set(lval);
		rightSol.set(rval);
	}
	
	public void setBoth(DoubleSolenoid.Value val) {
		leftSol.set(val);
		rightSol.set(val);
	}
	
	public void bothOff() {
		setBoth(DoubleSolenoid.Value.kOff);
	}
	
	public void bothForward() {
		setBoth(DoubleSolenoid.Value.kForward);
	}
	
	public void bothReverse() {
		setBoth(DoubleSolenoid.Value.kReverse);
	}
	
	public void grab() {
		bothForward();
		grabbed = true;
	}
	
	public void release() {
		bothReverse();
		grabbed = false;
	}
	
	public void toggle() {
		if(grabbed) {
			release();
		} else {
			grab();
		}
	}
	
	public boolean getGrabbed() {
		return grabbed;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

