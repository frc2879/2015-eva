package com.frc2879.eva.commands;

import com.frc2879.eva.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLiftDown extends Command {

    public MoveLiftDown() {
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
    	
    	Robot.lift.set((-(lefttrigger / 4)) + 0.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.oi.getDriveJoystick().lt.getX() == 0 || Robot.lift.isRevLimitSwitchClosed());
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
