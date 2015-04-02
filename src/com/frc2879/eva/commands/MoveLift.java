package com.frc2879.eva.commands;

import com.frc2879.eva.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLift extends Command {

    public MoveLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.releaseBrake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double lefttrigger = Robot.oi.getDriveJoystick().lt.getX();
    	double righttrigger = Robot.oi.getDriveJoystick().rt.getX();
    	
//    	if(righttrigger >= lefttrigger) {
//    		Robot.lift.set(righttrigger);
//    	} else {
//    		Robot.lift.set(-lefttrigger);
//    	}
    	
    	Robot.lift.set(righttrigger - lefttrigger);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.oi.getDriveJoystick().lt.getX() == 0 && Robot.oi.getDriveJoystick().rt.getX() == 0);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.set(0);
    	Robot.lift.engageBrake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//end();
    }
}
