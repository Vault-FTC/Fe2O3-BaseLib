package org.firstinspires.ftc.teamcode.CommandSystem;

import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;

public class Trigger {
    private final BooleanSupplier button;

    public Trigger(BooleanSupplier condition){
        this.button = condition;
    }

    private void addBinding(Binding binding){
        CommandScheduler.getInstance().addBinding(binding);
    }

    public void onTrue(Command command) {
        this.addBinding(new Binding((previous, current) -> {
            if (!previous && current) {
                command.schedule();
            }
        }, button));
    }

    public void onFalse(Command command) {
        this.addBinding(new Binding((previous, current) -> {
            if (previous &&  !current) {
                command.schedule();
            }
        }, button));
    }

    public void onChange(Command command) {
        this.addBinding(new Binding((previous, current) -> {
            if (previous != current) {
                command.schedule();
            }
        }, button));
    }

    public void whileTrue(Command command){
        this.addBinding(new Binding((previous, current) -> {
            if (!previous && current) {
                command.schedule();
            } else if (previous && !current){
                command.cancel();
            }
        }, button));
    }

    public void whileFalse(Command command){
        this.addBinding(new Binding((previous, current) -> {
            if (previous && !current) {
                command.schedule();
            } else if (!previous && current){
                command.cancel();
            }
        }, button));
    }

    public Trigger and(BooleanSupplier trigger){
        return new Trigger(() -> trigger.getAsBoolean() && button.getAsBoolean());
    }

    public Trigger or(BooleanSupplier trigger){
        return new Trigger(() -> trigger.getAsBoolean() || button.getAsBoolean());
    }
}
