package org.firstinspires.ftc.teamcode.OpMode.Subsystems;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.CommandSystem.Subsystem;
import org.firstinspires.ftc.teamcode.OpMode.Constants;

public class ShooterSubsystem extends Subsystem {
    final private Servo gateServo;
    final private DcMotor shooterMotor;
    boolean gateOpen = false;

    Telemetry telemetry;
    public ShooterSubsystem(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        gateServo = hardwareMap.get(Servo.class, Constants.MotorNames.gateServo);
        shooterMotor = hardwareMap.get(DcMotor.class, Constants.MotorNames.shooter);
    }

    public void toggleGate(){
        gateOpen = !gateOpen;
        gateServo.setPosition(gateOpen ? 0. : 1.);
    }

    /**
     * @param power will be negated, as the power outwards is accounted for, and negative.
     */
    public void shoot(double power){
        shooterMotor.setPower(-power);
    }
    @Override
    public void periodic(){
    }
}
