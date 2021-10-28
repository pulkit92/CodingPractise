package com.parking.service;


import com.parking.model.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ParkingService {

    List<CarParkingSlot> carParkingSlotList = null;
    List<TwoWheelerParkingSlot> twoWheelerParkingSlots = null;
    private Date date;
    List<Ticket> ticketList = null;
    private static final int minimumTime = 60;

    private static final double fee = 20;

    public void createParkingLot(ParkingLotInputCapacity parkingLotInputCapacity, String name) {
        ParkingLot parkingLot = new ParkingLot(name);
        ticketList = new ArrayList<>();

        carParkingSlotList = parkingLot.getCarParkingSlots(parkingLotInputCapacity.getCarCapacity());
        twoWheelerParkingSlots = parkingLot.getTwoWheelerParkingSlots(parkingLotInputCapacity.getBikeCapacity());
    }

    public Ticket park(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;
        if (vehicle instanceof Car) {
            parkingSlot = checkAvailabilityCar(vehicle);
        } else if (vehicle instanceof TwoWheeler) {
            parkingSlot = checkAvailabilityTwoWheeler(vehicle);
        }

        if (parkingSlot != null) {
            long startTimeMilliseconds = System.currentTimeMillis();

            Ticket ticket = new Ticket(parkingSlot.getSlotNumber(), startTimeMilliseconds, date, vehicle.getVechileType());
            ticketList.add(ticket);

            parkingSlot.setAvailability(false);
            return ticket;
        }
        return null;
    }

    public synchronized CarParkingSlot checkAvailabilityCar(Vehicle vehicle) {

        for (int i = 0; i < carParkingSlotList.size(); i++) {
            CarParkingSlot carParkingSlot = carParkingSlotList.get(i);

            if (carParkingSlot.getAvailability() == true) {
                return carParkingSlot;
            }
        }

        return null;
    }

    public synchronized TwoWheelerParkingSlot checkAvailabilityTwoWheeler(Vehicle vehicle) {

        for (int i = 0; i < carParkingSlotList.size(); i++) {
            TwoWheelerParkingSlot twoWheelerParkingSlot = twoWheelerParkingSlots.get(i);

            if (twoWheelerParkingSlot.getAvailability() == true) {
                return twoWheelerParkingSlot;
            }
        }

        return null;
    }

    public double exit(Ticket ticket) {
        validateTicketNumber(ticket.getSlotNumber());
        long timeParked = calculateTotalMinutes(ticket);
        double amt = getTotalFee(timeParked);
        makeSlotAvailable(ticket);
        return amt;
    }

    public boolean validateTicketNumber(int ticketNumEntered) {
        boolean isValid = false;

        for (int i = 0; i < ticketList.size(); i++) {
            int slotNumber = ticketList.get(i).getSlotNumber();

            if (ticketNumEntered == slotNumber) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public long calculateTotalMinutes(Ticket ticket) {
        long endTimeMilliseconds = System.currentTimeMillis();
        long durationMilliSeconds = endTimeMilliseconds - ticket.getStartTime();
        String durationParked = convertTimeFormat(durationMilliSeconds);
        String[] time = durationParked.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        return (hours * 60) + minutes + (seconds / 60);
    }

    private String convertTimeFormat(long milliSeconds) {
        long totalSeconds = milliSeconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        return currentHour + ":" + currentMinute + ":" + currentSecond;

    }

    public double getTotalFee(long timeInMinutes) {
        double totalFee = 0;
        {
            if (timeInMinutes < 60)
                totalFee = 30;
            else
                totalFee = (timeInMinutes / minimumTime) * fee;
        }

        return totalFee;
    }

    public void makeSlotAvailable(Ticket ticket) {
        if (ticket.getVechileType() == VechileType.CAR) {
            for (int i = 0; i < carParkingSlotList.size(); i++) {
                int slotNumber = carParkingSlotList.get(i).getSlotNumber();

                if (ticket.getSlotNumber() == slotNumber) {
                    CarParkingSlot carParkingSlot = carParkingSlotList.get(i);
                    carParkingSlot.setAvailability(true);
                }
            }
        } else {
            for (int i = 0; i < twoWheelerParkingSlots.size(); i++) {
                int slotNumber = twoWheelerParkingSlots.get(i).getSlotNumber();

                if (ticket.getSlotNumber() == slotNumber) {
                    TwoWheelerParkingSlot carParkingSlot = twoWheelerParkingSlots.get(i);
                    carParkingSlot.setAvailability(true);
                }
            }

        }
    }
}