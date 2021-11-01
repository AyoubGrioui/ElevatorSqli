package com.sqli.elevators.states;

import com.sqli.elevators.Elevator;

public class RestState extends ElevatorState {
    public RestState(Elevator elevator) {
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
        elevator.changeState(new StopState(elevator));
    }

    @Override
    public void rest() {
        throw new IllegalStateException("elevator already resting");
    }

    @Override
    public int distanceFromFloor(int floor) {
        return Math.abs(floor - elevator.getCurrentFloor());
    }
}
