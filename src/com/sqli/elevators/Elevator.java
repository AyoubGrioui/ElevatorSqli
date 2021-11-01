package com.sqli.elevators;

import com.sqli.elevators.states.ElevatorState;
import com.sqli.elevators.states.RestState;

public class Elevator {
    private String id;
    private int currentFloor;
    private int numberOfFloors;

    private ElevatorState elevatorState;

    public Elevator(String id, int currentFloor, int numberOfFloors) {

        this.elevatorState = new RestState(this);
        this.id = id;
        this.currentFloor = currentFloor;
        this.numberOfFloors = numberOfFloors;
    }

    public void changeState(ElevatorState state) {
        this.elevatorState = state;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public String getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
}
