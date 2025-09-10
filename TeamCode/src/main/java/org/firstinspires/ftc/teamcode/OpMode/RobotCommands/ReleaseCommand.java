package org.firstinspires.ftc.teamcode.OpMode.RobotCommands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.ShooterSubsystem;

public class ReleaseCommand extends Command {
    private final ShooterSubsystem shooterSys;
    private final ElapsedTime timer;
    private final double time;

    /**
     * @param time in seconds
     */
    public ReleaseCommand(ShooterSubsystem shooterSubsystem, double time){
        this.shooterSys = shooterSubsystem;
        this.time = time;
        timer = new ElapsedTime();
    }

    @Override
    public void init(){
        timer.reset();
        shooterSys.toggleGate();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished(){
        return (timer.seconds() > time);
    }

    @Override
    public void end(boolean interrupted){
        shooterSys.toggleGate();
    }
}
