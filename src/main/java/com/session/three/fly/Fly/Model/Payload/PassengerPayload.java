package com.session.three.fly.Fly.Model.Payload;

public class PassengerPayload {

    private String name;
    private Integer document;
    private String seatNumber;
    private String code;
    private String nameAirplane;

    public PassengerPayload(String name, Integer document, String seatNumber, String code, String nameAirplane) {
        this.name = name;
        this.document = document;
        this.seatNumber = seatNumber;
        this.code = code;
        this.nameAirplane = nameAirplane;
    }

    public PassengerPayload() {
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameAirplane() {
        return nameAirplane;
    }

    public void setNameAirplane(String nameAirplane) {
        this.nameAirplane = nameAirplane;
    }
}
