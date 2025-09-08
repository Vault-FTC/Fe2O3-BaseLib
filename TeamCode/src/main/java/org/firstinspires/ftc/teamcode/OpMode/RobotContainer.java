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

    Servo servo;

    public RobotContainer(Gamepad gamepadA, Gamepad gamepadB, HardwareMap hardwareMap, Telemetry telemetry){
        this.controllerA = new Controller(gamepadA);
        this.controllerB = new Controller(gamepadB);
        //shooterSys = new ShooterSubsystem(hardwareMap);
        this.telemetry = telemetry;
        servo = hardwareMap.get(Servo.class, "gate");
        configureBindings();
    }
    private void configureBindings(){
        controllerA.x().onTrue(new InstantCommand(() -> servo.setPosition(0)));
        controllerA.a().onTrue(new InstantCommand(() -> servo.setPosition(1)));
    }
}
