package com.sqli.elevators.states;

import com.sqli.elevators.Elevator;

public class UpState extends ElevatorState{


    public UpState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void up() {
        throw new IllegalStateException("Elevator is already going up");
    }

    @Override
    public void down() {
        throw new IllegalStateException("Elevator is going up and cannot go down");
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
        if (floor >= elevator.getCurrentFloor())
            return floor - elevator.getCurrentFloor();
        else
            return floor + elevator.getNumberOfFloors() - elevator.getCurrentFloor();
    }
}
