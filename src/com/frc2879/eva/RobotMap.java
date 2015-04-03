package com.frc2879.eva;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	int robot;
	
	public RobotMap(int r){
		robot = r;
	}
	
	public static final int DriveJoystick = 0;
	
	public class CANDevices {
		

		public static final int LEFT_DRIVE = 1;
		public static final int RIGHT_DRIVE = 2;
		
		public static final int LIFT_MOTOR_1 = 3;
		public static final int LIFT_MOTOR_2 = 4;
	}
	
	public class Power {
		public static final int LEFT_DRIVE = 0;
		public static final int RIGHT_DRIVE = 1;

		public static final int LIFT_MOTOR_1 = 2;
		public static final int LIFT_MOTOR_2 = 3;
	}
	
	public class PCM {
		public static final int PCM_CAN = 0;
		
		public static final int BRAKE_SOL = 4;
		
		public static final int LEFT_ARM_SOL_F = 0;
		public static final int LEFT_ARM_SOL_R = 1;
		
		public static final int RIGHT_ARM_SOL_F = 2;
		public static final int RIGHT_ARM_SOL_R = 3;
	}
	
}
