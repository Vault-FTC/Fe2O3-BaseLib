package org.firstinspires.ftc.teamcode.OpMode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.CommandSystem.InstantCommand;
import org.firstinspires.ftc.teamcode.Controllers.Controller;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.ShooterSubsystem;

public class RobotContainer {
    // Gamepads
    Controller controllerA;
    Controller controllerB;

    // Subsystems
    ShooterSubsystem shooterSys;
    DriveSubsystem driveSubsystem;
    // Default Commands

    public RobotContainer(Gamepad gamepadA, Gamepad gamepadB, HardwareMap hardwareMap){
        this.controllerA = new Controller(gamepadA);
        this.controllerB = new Controller(gamepadB);
        shooterSys = new ShooterSubsystem(hardwareMap);


    }

    private void configureBindings(){
        controllerA.a().onTrue(new InstantCommand(() -> shooterSys.toggleShooter()));
        controllerA.b().onTrue(new InstantCommand(() -> shooterSys.toggleGate()));
    }

}
