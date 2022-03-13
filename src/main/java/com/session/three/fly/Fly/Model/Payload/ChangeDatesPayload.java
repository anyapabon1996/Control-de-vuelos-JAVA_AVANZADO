package com.session.three.fly.Fly.Model.Payload;

import java.time.LocalDate;

public class ChangeDatesPayload {
    private LocalDate departure;
    private LocalDate arraving;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
