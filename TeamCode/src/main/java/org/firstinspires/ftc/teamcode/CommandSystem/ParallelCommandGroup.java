package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.ArrayList;
import java.util.List;

public class ParallelCommandGroup extends Command{
    List<Command> commands = new ArrayList<>();
    public ParallelCommandGroup(Command... givenCommands){
        for (Command command : givenCommands){
            required.addAll(command.required);
            commands.add(command);
        }
    }

    @Override
    public void execute(){
        for (Command command : commands){
            command.execute();
        }
    }

    @Override
    public void cancel(){
        for (Command command : commands){
            command.cancel();
        }
    }
}
