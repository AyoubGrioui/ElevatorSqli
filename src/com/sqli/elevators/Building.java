package com.sqli.elevators;

import com.sqli.elevator_factory.ConcreteElevatorFactory;
import com.sqli.elevator_factory.ElevatorFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Building {

    private int numberOfFloors ;
    private Map<String,Elevator> elevators;
    private ElevatorFactory elevatorFactory = ConcreteElevatorFactory.getINSTANCE();

    public Building(int numberOfFloors,String... elevators)
    {
        this.numberOfFloors = numberOfFloors;
        this.elevators = new HashMap<>();

        Arrays.stream(elevators).forEach(elevator -> {
            var el = elevatorFactory.createElevator(elevator,numberOfFloors);
            this.elevators.put(el.getId(),el);
        });
    }


    public String requestElevator()
    {
        var min = Integer.MAX_VALUE;
        String closestElevator = null;

        var elevatorsIds = elevators.keySet();

        for(String id : elevatorsIds)
        {
            if(elevators.get(id).getElevatorState().distanceFromFloor(numberOfFloors)!=-1
                    && elevators.get(id).getElevatorState().distanceFromFloor(numberOfFloors)<=min) {
                min = elevators.get(id).getElevatorState().distanceFromFloor(numberOfFloors);
                closestElevator = id;
            }
        }
        return closestElevator;
    }

    public String requestElevator(int floor)
    {
        var min = Integer.MAX_VALUE;
        String closestElevator = null;

        var elevatorsIds = elevators.keySet();

        for(String id : elevatorsIds)
        {
            if(elevators.get(id).getElevatorState().distanceFromFloor(floor)!=-1
                    && elevators.get(id).getElevatorState().distanceFromFloor(floor)<=min) {
                min = elevators.get(id).getElevatorState().distanceFromFloor(floor);
                closestElevator = id;
            }
        }
        return closestElevator;
    }

    public void move(String identifier,String action)
    {
        Elevator elevator = elevators.get(identifier);
        switch (action) {
            case "UP" : elevator.getElevatorState().up(); break;
            case "DOWN" : elevator.getElevatorState().down(); break;
            default : throw new IllegalStateException("elevator can only go up or down");
        }
    }

    public  void  stopAt(String identifier,int floor)
    {
        Elevator elevator = elevators.get(identifier);
        elevator.setCurrentFloor(floor);
        elevator.getElevatorState().stop();
    }
}
