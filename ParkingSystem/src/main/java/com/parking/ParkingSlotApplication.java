package com.parking;

import com.parking.model.Car;
import com.parking.model.ParkingLotInputCapacity;
import com.parking.model.Ticket;
import com.parking.model.Vehicle;
import com.parking.service.ParkingService;

public class ParkingSlotApplication
{
    public  static  void main(String args[]){
        ParkingService parkingService=new ParkingService();
        ParkingLotInputCapacity parkingLotInputCapacity=new ParkingLotInputCapacity();
        parkingLotInputCapacity.setBikeCapacity(10);
        parkingLotInputCapacity.setCarCapacity(20);
        parkingService.createParkingLot(parkingLotInputCapacity,"A");
        Vehicle vehicle=new Car("KA 05 52");
        Ticket ticket=parkingService.park(vehicle);
        System.out.println(parkingService.exit(ticket));
    }
}
