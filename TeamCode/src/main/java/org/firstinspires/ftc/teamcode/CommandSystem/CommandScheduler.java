package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;

public class CommandScheduler {
    private static CommandScheduler instance;
    ArrayList<Subsystem> subsystems;
    ArrayList<Subsystem> activeSubsystems;
    ArrayList<Command> activeCommands;
    ArrayList<Binding> bindings;
    ArrayList<Command> defaultCommands;

    public static CommandScheduler getInstance() {
        if (instance == null) {
            instance = new CommandScheduler();
        }
        return instance;
    }

    public void schedule(Command command){};
    public void register(Subsystem subsystem){
        subsystems.add(subsystem);
    }
    public void cancel(Command command){
        command.realEnd(true);
        activeCommands.remove(command);
    };

    public void addBinding(Binding binding){};

    public void run(){
        for (Binding binding : bindings){
            binding.checkBinding();
        }
        for (Command command : activeCommands){
            if (command.isFinished()){
                command.realEnd(false);
                activeCommands.remove(command);
                continue;
            }

            boolean canRun = true;
            for (Subsystem subsystem: command.required){
                if (activeSubsystems.contains(subsystem)){
                    canRun = false;
                    break;
                }
                activeSubsystems.add(subsystem);
            }
            if (canRun){
                command.execute();
            }
        }
        for (Subsystem subsystem : subsystems){
            subsystem.periodic();
        }
    }
}
