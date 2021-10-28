package com.parking.model;

public abstract class Vehicle {
    private String vehicleNo;

    public Vehicle(VechileType vechileType,String vechileNo){
        this.vechileType=vechileType;
        this.vehicleNo=vehicleNo;
    }
    public VechileType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
    }

    private VechileType vechileType;

}
