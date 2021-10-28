package com.parking.service;

import com.parking.model.CarParkingSlot;
import com.parking.model.TwoWheelerParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<CarParkingSlot> carParkingSlots = null;
    private List<TwoWheelerParkingSlot> twoWheelerParkingSlots = null;

    public ParkingLot(String name) {
        carParkingSlots = new ArrayList<>();
        twoWheelerParkingSlots = new ArrayList<>();
        this.name = name;

    }

    public List<CarParkingSlot> getCarParkingSlots(int slots) {
        for (int i = 1; i <= slots; i++) {
            CarParkingSlot slot = new CarParkingSlot(i, true);
            carParkingSlots.add(slot);
        }
        return carParkingSlots;
    }

    public List<TwoWheelerParkingSlot> getTwoWheelerParkingSlots(int slots) {
        for (int i = 1; i <= slots; i++) {
            TwoWheelerParkingSlot slot = new TwoWheelerParkingSlot(i, true);
            twoWheelerParkingSlots.add(slot);
        }
        return twoWheelerParkingSlots;
    }
}
