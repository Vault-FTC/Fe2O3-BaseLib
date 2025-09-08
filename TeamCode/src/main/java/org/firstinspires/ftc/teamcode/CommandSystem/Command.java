package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;

public abstract class Command {
    protected ArrayList<Subsystem> required;

    public void init(){
    }

    public void execute(){
    }

    public void end(boolean interrupted){
    }

    protected void realEnd(boolean interrupted){
        end(interrupted);
    }

    public boolean isFinished(){
        return false;
    }

    public void schedule(){
        CommandScheduler.getInstance().schedule(this);
    };
    public void  cancel(){
        CommandScheduler.getInstance().cancel(this);
    };
}
