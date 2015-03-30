package com.frc2879.eva.subsystems;

import com.frc2879.eva.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	final Compressor compressor;
	
	public Pneumatics() {
		compressor = new Compressor(RobotMap.PCM.PCM_CAN);
		compressor.setClosedLoopControl(true);
	}
	
	public Compressor getCompressor() {
		return compressor;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

