package com.solution;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.solution.AbstractFactory.logger;
import static com.solution.AbstractVehicleFactory.getFactory;
import static com.solution.VehicleType.CAR;
import static com.solution.VehicleType.PLANE;
import static com.solution.VehicleType.SHIP;

public class AbstractFactory {
    public static final Logger logger = Logger.getLogger(AbstractFactory.class.getName());

    public static void main(String[] args) {
        VehicleFactory airFactory = getFactory(FactoryType.AIR);
        if (airFactory != null) {
            Vehicle plane = airFactory.create(VehicleType.PLANE);
            plane.move();
        } else {
            logger.log(Level.WARNING, "Invalid factory type");
        }
    }
}

enum FactoryType {
    AIR, SEA, LAND
}

enum VehicleType {
    PLANE, CAR, SHIP
}

interface Vehicle {
    void move();
}

class Plane implements Vehicle {
    public void move() {
        logger.log(Level.INFO, "Flying");
    }
}

class Car implements Vehicle {
    public void move() {
        logger.log(Level.INFO, "Driving");
    }
}

class Transport implements Vehicle {
    public void move() {
        logger.log(Level.INFO, "Moving");
    }
}

class Ship implements Vehicle {
    public void move() {
        logger.log(Level.INFO, "Sailing");
    }
}

interface VehicleFactory {
    Vehicle create(VehicleType type);
}

class AirVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle create(VehicleType type) {
        return type == PLANE
                ? new Plane()
                : new Transport();
    }
}

class SeaVehicleFactory implements VehicleFactory {
    public Vehicle create(VehicleType type) {
        return type == SHIP
                ? new Ship()
                : new Transport();
    }
}

class LandVehicleFactory implements VehicleFactory {
    public Vehicle create(VehicleType type) {
        return type == CAR
                ? new Car()
                : new Transport();
    }
}

class AbstractVehicleFactory {
    private AbstractVehicleFactory() {
    }

    public static VehicleFactory getFactory(FactoryType factoryType) {
        if (factoryType == FactoryType.AIR) {
            return new AirVehicleFactory();
        } else if (factoryType == FactoryType.SEA) {
            return new SeaVehicleFactory();
        } else if (factoryType == FactoryType.LAND) {
            return new LandVehicleFactory();
        }
        return null;
    }
}
