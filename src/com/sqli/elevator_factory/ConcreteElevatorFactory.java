package com.sqli.elevator_factory;

import com.sqli.elevators.Elevator;

public class ConcreteElevatorFactory extends ElevatorFactory {

    private static ConcreteElevatorFactory  instance = null ;

    private ConcreteElevatorFactory(){}

    public static ConcreteElevatorFactory getINSTANCE() {
        if(instance==null)
            instance = new ConcreteElevatorFactory();
        return instance;
    }

    @Override
    public Elevator createElevator(String identifier,int numberOfFloors) {

        var id = identifier.split(":")[0];
        var currentFloor = Integer.parseInt(identifier.split(":")[1]);
        return new Elevator(id,currentFloor,numberOfFloors);
    }
}
