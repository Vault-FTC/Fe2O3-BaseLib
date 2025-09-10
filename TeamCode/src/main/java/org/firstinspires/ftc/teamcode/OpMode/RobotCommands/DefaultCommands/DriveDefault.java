package org.firstinspires.ftc.teamcode.OpMode.RobotCommands.DefaultCommands;

import org.firstinspires.ftc.teamcode.CommandSystem.DefaultCommand;
import org.firstinspires.ftc.teamcode.OpMode.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.geometry.Vector2D;

import java.util.Vector;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class DriveDefault extends DefaultCommand {
    private boolean fieldCentric = false;
    private final DriveSubsystem driveSys;
    private final Supplier<Vector2D> transSupp;
    private final DoubleSupplier rotationSupp;


    public DriveDefault(DriveSubsystem driveSubsystem, Supplier<Vector2D> transSupp, DoubleSupplier rotationSupp){
        this.driveSys = driveSubsystem;
        this.transSupp = transSupp;
        this.rotationSupp = rotationSupp;
    }

    public void toggleFieldCentric(){
        fieldCentric = !fieldCentric;
    }

    @Override
    public void execute(){
        Vector2D transVect = transSupp.get();
        double rotVect = rotationSupp.getAsDouble();
        driveSys.drive(transVect, rotVect, fieldCentric);
    }
}
