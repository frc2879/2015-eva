package com.frc2879.eva.commands;

import com.frc2879.eva.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveLiftUp extends Command {

    public MoveLiftUp() {
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
    	double righttrigger = Robot.oi.getDriveJoystick().rt.getX();

    	Robot.lift.set((righttrigger) / 2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.oi.getDriveJoystick().rt.getX() == 0 || Robot.lift.isFwdLimitSwitchClosed());
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
