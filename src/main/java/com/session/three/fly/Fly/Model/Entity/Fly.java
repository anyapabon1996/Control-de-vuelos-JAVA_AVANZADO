package com.session.three.fly.Fly.Model.Entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Fly")
public class Fly {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fly_id")
    private Integer idFly;

    @Column(name = "Departure")
    private LocalDate departure;

    @Column(name = "Arraving")
    private LocalDate arraving;

    @Column(name = "Boarding")
    private String boarding;

    @Column(name = "Fly_code")
    private String flyCode;

    //un avión está asociado a varios pasajeros
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "fly")
    private List<Passenger> passengerList;

    //Constructores
    public Fly(LocalDate departure, LocalDate arraving, String boarding, String flyCode) {
        this.departure = departure;
        this.arraving = arraving;
        this.boarding = boarding;
        this.flyCode = flyCode;
    }

    public Fly(){

    }

    //Getter and Setter
    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
    }

    public LocalDate getArraving() {
        return arraving;
    }

    public void setArraving(LocalDate arraving) {
        this.arraving = arraving;
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }

    public String getFlyCode() {
        return flyCode;
    }

    public void setFlyCode(String flyCode) {
        this.flyCode = flyCode;
    }

    public void setPassengerList(Passenger passenger){
        if (this.passengerList == null) this.passengerList = new ArrayList<>();

        //agregamos el pasajero al vuelo
        this.passengerList.add(passenger);

        //le asociaso a este pasajero, este vuelo
        passenger.setFly(this);
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFly, departure, arraving, boarding, flyCode, passengerList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fly that = (Fly) o;
        return Objects.equals(idFly, that.idFly) && departure == that.departure && Objects.equals(arraving, that.arraving) && Objects.equals(boarding, that.boarding)
                && Objects.equals(flyCode, that.flyCode) && Objects.equals(passengerList, that.passengerList);
    }
}
