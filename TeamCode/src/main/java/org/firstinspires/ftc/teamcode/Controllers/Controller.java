package org.firstinspires.ftc.teamcode.Controllers;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.Trigger;
import org.firstinspires.ftc.teamcode.geometry.Vector2D;

import java.util.Vector;
import java.util.function.DoubleSupplier;
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
    public Trigger back(){return new Trigger(() -> baseController.back);}
    public Trigger circle(){return new Trigger(() -> baseController.circle);}
    public Trigger cross(){return new Trigger(() -> baseController.cross);}
    public Trigger dpadDown(){return new Trigger(() -> baseController.dpad_down);}
    public Trigger dpadLeft(){return new Trigger(() -> baseController.dpad_left);}
    public Trigger dpadUp(){return new Trigger(() -> baseController.dpad_up);}
    public Trigger dpadRight(){return new Trigger(() -> baseController.dpad_right);}
    public Trigger guide(){return new Trigger(() -> baseController.guide);}
    public Trigger leftBumper(){return new Trigger(() -> baseController.left_bumper);}
    public Trigger leftStickButton(){return new Trigger(() -> baseController.left_stick_button);}
    public Trigger options(){return new Trigger(() -> baseController.options);}
    public Trigger ps(){return new Trigger(() -> baseController.ps);}
    public Trigger rightBumper(){return new Trigger(() -> baseController.right_bumper);}
    public Trigger rightStickButton(){return new Trigger(() -> baseController.right_stick_button);}
    public Trigger share(){return new Trigger(() -> baseController.share);}
    public Trigger start(){return new Trigger(() -> baseController.start);}
    public Trigger square(){return new Trigger(() -> baseController.square);}
    public Trigger triangle(){return new Trigger(() -> baseController.triangle);}
    public Trigger leftTrigger(){return new Trigger(() -> (baseController.left_trigger > 1e-3));}
    public Trigger rightTrigger(){return new Trigger(() -> (baseController.right_trigger > 1e-3));}

    public DoubleSupplier leftTriggerSupp(){return () -> baseController.left_trigger;}
    public DoubleSupplier rightTriggerSupp(){return () -> baseController.right_trigger;}





















    public Supplier<Vector2D> getLSSupp(){
        return () -> new Vector2D(baseController.left_stick_x, baseController.left_stick_y);
    }

    public DoubleSupplier getLeftX(){
        return () -> baseController.left_stick_x;
    }

    public DoubleSupplier getLeftY(){
        return () -> baseController.left_stick_y;
    }

    public Supplier<Vector2D> getRSSupp() {
        return () -> new Vector2D(baseController.right_stick_x, baseController.right_stick_y);
    }

    public DoubleSupplier getRightX(){
        return () -> baseController.right_stick_x;
    }

    public DoubleSupplier getRightY(){
        return () -> baseController.right_stick_y;
    }

}
