package org.firstinspires.ftc.teamcode.OpMode.RobotCommands;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
    ShooterSubsystem shooterSys;
    double power;
    public ShootCommand(ShooterSubsystem shooterSubsystem, double power){
        this.shooterSys = shooterSubsystem;
        this.power = power;
    }

    @Override
    public void execute() {
        shooterSys.shoot(power);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        shooterSys.shoot(0);
    }
}
