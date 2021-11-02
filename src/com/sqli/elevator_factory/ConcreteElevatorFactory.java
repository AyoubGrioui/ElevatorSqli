package com.sqli.elevator_factory;

import com.sqli.elevators.Elevator;

public class ConcreteElevatorFactory extends ElevatorFactory {

    private static ConcreteElevatorFactory  INSTANCE = null ;

    private ConcreteElevatorFactory(){};

    public static ConcreteElevatorFactory getINSTANCE() {
        if(INSTANCE==null)
            INSTANCE = new ConcreteElevatorFactory();
        return INSTANCE;
    }

    @Override
    public Elevator createElevator(String identifier,int numberOfFloors) {

        var id = identifier.split(":")[0];
        var currentFloor = Integer.parseInt(identifier.split(":")[1]);
        return new Elevator(id,currentFloor,numberOfFloors);
    }
}
