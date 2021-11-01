package com.sqli.elevators.states;

import com.sqli.elevators.Elevator;

public class StopState extends ElevatorState{
    protected StopState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void up() {
        elevator.changeState(new UpState(elevator));
    }

    @Override
    public void down() {
        elevator.changeState(new DownState(elevator));
    }

    @Override
    public void stop() {
        throw new IllegalStateException("elevator already stopped");
    }

    @Override
    public void rest() {
        elevator.changeState(new RestState(elevator));
    }

    @Override
    public int distanceFromFloor(int floor) {
        return -1;
    }
}
