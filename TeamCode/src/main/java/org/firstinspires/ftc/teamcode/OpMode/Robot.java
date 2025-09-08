package org.firstinspires.ftc.teamcode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.CommandSystem.CommandScheduler;

@TeleOp
public class Robot extends OpMode {

    private RobotContainer robotContainer;

    @Override
    public void init(){
        robotContainer = new RobotContainer(gamepad1, gamepad2, hardwareMap);
    }

    @Override
    public void loop(){
        CommandScheduler.getInstance().run();
    }
}
