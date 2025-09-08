package org.firstinspires.ftc.teamcode.OpMode.DefaultCommands;

import org.firstinspires.ftc.teamcode.CommandSystem.DefaultCommand;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.ShooterSubsystem;

public class ShooterDefault extends DefaultCommand {
    private ShooterSubsystem shooterSys;

    public ShooterDefault(ShooterSubsystem shooterSubsystem){
        this.shooterSys = shooterSubsystem;
        shooterSys.addRequirements(this);
        shooterSys.addDefault(this);
    }

    @Override
    public void init(){
    }

    @Override
    public void execute() {
    }
}
