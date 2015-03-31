
package com.frc2879.eva;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.frc2879.eva.commands.*;
import com.frc2879.eva.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final String NAME = "Eva";
    public static final String VERSION = "C.2015.003";
    public static final String FULLNAME = NAME + " " + VERSION;
	

	public static ExampleSubsystem exampleSubsystem;
	
	
	public static PowerDistributionPanel pdBoard;
	
	public static DriveTrain drivetrain;
	public static Lift lift;
	public static Arms arms;
	public static Pneumatics pneumatics;
	
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		// Initialize all subsystems
		pdBoard = new PowerDistributionPanel();
		drivetrain = new DriveTrain();
		lift = new Lift();
		arms = new Arms();
		pneumatics = new Pneumatics();
		
		exampleSubsystem = new ExampleSubsystem();
		
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand(); 
        
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(lift);
        SmartDashboard.putData(arms);
        SmartDashboard.putData(pneumatics);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
