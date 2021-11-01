package com.sqli.elevator_factory;

import com.sqli.elevators.Elevator;

public abstract class ElevatorFactory {

    public abstract Elevator createElevator(String identifier,int numberOfFloors);
}
