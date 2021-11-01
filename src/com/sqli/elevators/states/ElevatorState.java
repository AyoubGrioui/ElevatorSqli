package com.sqli.elevators.states;

import com.sqli.elevators.Elevator;

public abstract class ElevatorState {

    protected Elevator elevator;

    protected ElevatorState(Elevator elevator) {
        this.elevator = elevator;
    }

    public abstract void up();

    public abstract void down();

    public abstract void stop();

    public abstract void rest();

    public abstract int distanceFromFloor(int floor);
}
