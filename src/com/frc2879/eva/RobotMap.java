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
		
		//Eva is 1 for left and 2 for right.
		//Bender is 5 and 6

		public static final int leftDrive = 1;
		public static final int rightDrive = 2;
		
		//Eva is 2 for motor1 and 3 for motor2
		public static final int LiftMotor1 = 5;
		public static final int LiftMotor2 = 6;
	}
	
	public class Power {
		public static final int LeftDrive = 0;
		public static final int RightDrive = 1;

		public static final int LiftMotor1 = 2;
		public static final int LiftMotor2 = 3;
	}
	
}
