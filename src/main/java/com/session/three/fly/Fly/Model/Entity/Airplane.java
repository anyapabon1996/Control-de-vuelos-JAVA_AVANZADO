package com.session.three.fly.Fly.Model.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Airplane")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Airplane_id")
    private Integer idAirplane;

    @Column(name = "Name")
    private String name;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Seat_quantity")
    private Integer seatQuantity;

    //Un avion, puede tener varios vuelos
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "airplane")
    private List<Passenger> passengerList;

    public Airplane(String name, String brand, String model, Integer seatQuantity) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.seatQuantity = seatQuantity;
    }

    public Airplane(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(Integer seatQuantity) {
        this.seatQuantity = seatQuantity;
    }

    public List<Passenger> getFlyList() {
        return passengerList;
    }

    public void setPassengerList(Passenger passenger) {
        if (this.passengerList == null) this.passengerList = new ArrayList<>();

        this.passengerList.add(passenger);

        passenger.setAirplane(this);


    }

    @Override
    public String toString() {
        return "Airplane{" +
                "idAirplane=" + idAirplane +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seatQuantity=" + seatQuantity +
                ", passengerList=" + passengerList +
                '}';
    }
}
