package com.parking.model;

import java.sql.Date;

public class Ticket {
    private int slotNumber;
    private long startTime;
    private Date date;
    private VechileType vechileType;
    private Vehicle vehicle;

    public Ticket(int slotNumber, long startTime, Date date, VechileType vechileType) {
        this.slotNumber = slotNumber;
        this.startTime = startTime;
        this.date = date;
        this.vechileType = vechileType;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public Date getDate() {
        return date;
    }
}