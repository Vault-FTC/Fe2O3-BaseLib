package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    protected List<Subsystem> required = new ArrayList<>();

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
