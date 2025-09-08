package org.firstinspires.ftc.teamcode.OpMode.Subsystems;

import androidx.core.math.MathUtils;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.CommandSystem.Subsystem;
import org.firstinspires.ftc.teamcode.OpMode.Constants;

public class ShooterSubsystem extends Subsystem {
    final private Servo gateServo;
    final private DcMotor shooterMotor;

    boolean shooting = false;
    boolean gateOpen = false;
    public ShooterSubsystem(HardwareMap hardwareMap){
        gateServo = hardwareMap.get(Servo.class, Constants.MotorNames.gateServo);
        shooterMotor = hardwareMap.get(DcMotor.class, Constants.MotorNames.shooter);
    }

    public void toggleGate(){
        gateOpen = !gateOpen;
    }

    public void toggleShooter(){
        shooting = !shooting;
    }

    // 0 - 1
    public void setGate(double position){
        gateServo.setPosition(MathUtils.clamp(0, 1, position));
    }

    // -1 - 1
    public void setShooterPower(double power){
        shooterMotor.setPower(power);
    }

    @Override
    public void periodic(){
        gateServo.setPosition(gateOpen ? 0. : 1.);
        if (shooting){
            shooterMotor.setPower(-.8);
        } else {
            shooterMotor.setPower(0);
        }
    }
}
