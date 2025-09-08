package org.firstinspires.ftc.teamcode.Controllers;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.Trigger;
import org.firstinspires.ftc.teamcode.geometry.Vector2D;

import java.util.Vector;
import java.util.function.Supplier;


/**
 * This class is a wrapper for Gamepad, so that it is more similar to FRC
 */
public class Controller{
    Gamepad baseController;
    public Controller(Gamepad gamepad){
        baseController = gamepad;
    }

    public Trigger a(){return new Trigger(() -> baseController.a);}
    public Trigger b(){return new Trigger(() -> baseController.b);}
    public Trigger x(){return new Trigger(() -> baseController.x);}
    public Trigger y(){return new Trigger(() -> baseController.y);}

    public Supplier<Vector2D> getLSSupp(){
        return () -> new Vector2D(baseController.left_stick_x, baseController.left_stick_y);
    }
    public Supplier<Vector2D> getRSSupp(){
        return () -> new Vector2D(baseController.right_stick_x, baseController.right_stick_y);
    }
}
