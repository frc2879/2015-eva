package com.frc2879.eva.commands;

import com.frc2879.eva.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetBrake extends Command {
	
	boolean solOn;

    public SetBrake(boolean e) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	solOn = e;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.setBrake(solOn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
