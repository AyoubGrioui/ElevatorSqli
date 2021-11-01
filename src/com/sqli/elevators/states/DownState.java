package com.sqli.elevators.states;

import com.sqli.elevators.Elevator;

public class DownState extends ElevatorState {
    public DownState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void up() {
        throw new IllegalStateException("Elevator is going down cannot go up");
    }

    @Override
    public void down() {
        throw new IllegalStateException("Elevator is already going down");
    }

    @Override
    public void stop() {
        elevator.changeState(new StopState(elevator));
    }

    @Override
    public void rest() {
        elevator.changeState(new RestState(elevator));
    }

    @Override
    public int distanceFromFloor(int floor) {
        if (floor <= elevator.getCurrentFloor())
            return elevator.getCurrentFloor() - floor;
        else
            return floor + elevator.getNumberOfFloors() - elevator.getCurrentFloor();
    }
}
