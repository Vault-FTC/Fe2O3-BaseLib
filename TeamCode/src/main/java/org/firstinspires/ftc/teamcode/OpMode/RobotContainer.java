package org.firstinspires.ftc.teamcode.OpMode;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.CommandSystem.CommandScheduler;
import org.firstinspires.ftc.teamcode.CommandSystem.InstantCommand;
import org.firstinspires.ftc.teamcode.Controllers.Controller;
import org.firstinspires.ftc.teamcode.OpMode.RobotCommands.DefaultCommands.DriveDefault;
import org.firstinspires.ftc.teamcode.OpMode.RobotCommands.ReleaseCommand;
import org.firstinspires.ftc.teamcode.OpMode.RobotCommands.ShootCommand;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.ShooterSubsystem;

public class RobotContainer {
    // Gamepads
    Controller controllerA;
    Controller controllerB;
    // Subsystems
    ShooterSubsystem shooterSys;
    DriveSubsystem driveSubsystem;

    Telemetry telemetry;
    // Default Commands
    DriveDefault driveDefault;


    public RobotContainer(Gamepad gamepadA, Gamepad gamepadB, HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;

        // Gamepads
        this.controllerA = new Controller(gamepadA);
        this.controllerB = new Controller(gamepadB);

        // Subsystems
        shooterSys = new ShooterSubsystem(hardwareMap, telemetry);
        driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);

        // Default Commands
        driveDefault = new DriveDefault(driveSubsystem, controllerA.getLSSupp(), controllerA.getRightX());
        driveSubsystem.addDefault(driveDefault);

        configureBindings();
    }
    private void configureBindings(){
        controllerA.a().whileTrue(new ReleaseCommand(shooterSys, 4));
        controllerA.b().whileTrue(new ShootCommand(shooterSys, .8));
    }
}
