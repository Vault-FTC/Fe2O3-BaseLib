package org.firstinspires.ftc.teamcode.CommandSystem;

public abstract class Subsystem {
    public Subsystem(){
        register();
    }
    public void periodic(){
    }
    public void addRequirements(Command command){
        command.required.add(this);
    }

    public void addDefault(DefaultCommand defaultCommand){
        if (!defaultCommand.required.contains(this)){
            addRequirements(defaultCommand);
        }
        CommandScheduler.getInstance().defaultCommands.add(defaultCommand);
    }

    private void register(){
        CommandScheduler.getInstance().register(this);
    }
}
