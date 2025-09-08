package org.firstinspires.ftc.teamcode.CommandSystem;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Function;

import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;

public class Binding {
    BiConsumer<Boolean, Boolean> run;
    BooleanSupplier button;
    boolean previous;
    public Binding(BiConsumer<Boolean, Boolean> run, BooleanSupplier button){
        this.button = button;
        this.previous = button.getAsBoolean();
        this.run = run;
    }

    public void checkBinding(){
        run.accept(previous, button.getAsBoolean());
        previous = button.getAsBoolean();
    }
}
