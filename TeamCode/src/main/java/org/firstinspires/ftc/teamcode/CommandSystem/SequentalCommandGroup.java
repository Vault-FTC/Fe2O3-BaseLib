package org.firstinspires.ftc.teamcode.CommandSystem;

import static java.lang.Thread.interrupted;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentalCommandGroup extends Command{
    ArrayList<Command> commands;

    boolean finished = false;
    int index = 0;
    public SequentalCommandGroup(Command... givenCommands){
        commands.addAll(Arrays.asList(givenCommands));
    }

    @Override
    public void execute() {
        if (index < commands.size()){
            if (commands.get(index).isFinished()){
                commands.get(index).realEnd(false);
                index += 1;
            }
            commands.get(index).execute();
        } else {
            index = 0;
            finished = true;
        }

    }

    @Override
    public boolean isFinished(){
        return finished;
    }

    @Override
    protected void realEnd(boolean interrupted){
    }
}
