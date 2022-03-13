package com.session.three.fly.Fly.Model.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Passenger_id")
    private Integer idPassenger;

    @Column(name = "First_name")
    private String name;

    @Column(name = "Document")
    private Integer document;

    @Column(name = "Seat_number")
    private String seatNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "Fly_id")
    private Fly fly;

    //Relaciones
    //Un vuelo está asociado a un avion, y un avión está asociado a varios vuelo. Muchos vuelos para un solo avion
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "Airplane_id")
    private Airplane airplane;

    public Passenger(Integer idPassenger, String name, Integer document, String seatNumber, Fly fly, Airplane airplane) {
        this.idPassenger = idPassenger;
        this.name = name;
        this.document = document;
        this.seatNumber = seatNumber;
        this.fly = fly;
        this.airplane = airplane;
    }

    public Passenger() {

    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }


}
