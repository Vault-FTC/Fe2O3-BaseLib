package org.firstinspires.ftc.teamcode.CommandSystem;

public class InstantCommand extends Command{
    Runnable toRun;
    public InstantCommand(Runnable toRun) {
        this.toRun = toRun;
    }

    @Override
    public void init(){
        toRun.run();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
