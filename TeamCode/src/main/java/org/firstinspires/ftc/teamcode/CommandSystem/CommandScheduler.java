package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;
import java.util.List;

public class CommandScheduler {
    private static CommandScheduler instance;
    List<Subsystem> subsystems = new ArrayList<>();
    List<Subsystem> activeSubsystems =  new ArrayList<>();
    List<Command> activeCommands = new ArrayList<>();
    List<Binding> bindings = new ArrayList<>();
    List<Command> defaultCommands = new ArrayList<>();

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
