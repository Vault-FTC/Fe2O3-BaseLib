package org.firstinspires.ftc.teamcode.OpMode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.CommandSystem.Subsystem;
import org.firstinspires.ftc.teamcode.OpMode.Constants;
import org.firstinspires.ftc.teamcode.geometry.Pose2D;
import org.firstinspires.ftc.teamcode.geometry.Vector2D;

public class DriveSubsystem extends Subsystem {
    DcMotor[] driveMotors;
    private Pose2D robotPose = new Pose2D();

    private Telemetry telemetry;
    public DriveSubsystem(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        driveMotors = new DcMotor[]{
                hardwareMap.get(DcMotor.class, Constants.MotorNames.leftFront),
                hardwareMap.get(DcMotor.class, Constants.MotorNames.rightFront),
                hardwareMap.get(DcMotor.class, Constants.MotorNames.leftBack),
                hardwareMap.get(DcMotor.class, Constants.MotorNames.rightBack)
        };
        for (DcMotor motor : driveMotors) {
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }

    public void drive(Vector2D transVect, double rotation, boolean fieldCentric){
        if (fieldCentric){
            transVect.rotateBy(robotPose.getHeading());
        }
        double[] powers = findPower(transVect, rotation);
        for (int i = 0; i < 4; i++){
            driveMotors[i].setPower(powers[i]);
        }
    }

    private double[] findPower(Vector2D trans, double rotation){
        // lf, rf, lb, rb
        return new double[]{
                -trans.getY() - trans.getX() - rotation, // lf
                trans.getY() - trans.getX() - rotation, // rf
                -trans.getY() + trans.getX() - rotation, // lb
                trans.getY() + trans.getX() - rotation //rb
        };
    }

    private void updateOdometry(){
        //TODO Update robotPose with math done here.
    }

    public Pose2D getRobotPose(){
        //TODO Does not work until odometry code is implemented.
        return robotPose.copy();
    }

    @Override
    public void periodic(){
        updateOdometry();
    }
}
