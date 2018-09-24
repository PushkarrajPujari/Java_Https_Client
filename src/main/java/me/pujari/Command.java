package me.pujari;

@FunctionalInterface
public interface Command {
    public Object execute();
}
