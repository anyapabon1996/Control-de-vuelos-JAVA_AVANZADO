package com.session.three.fly.Fly.restControllerTest;

import com.session.three.fly.Fly.Controller.RestFlyController;
import com.session.three.fly.Fly.Model.Entity.Airplane;
import com.session.three.fly.Fly.Model.Entity.Fly;
import com.session.three.fly.Fly.Model.Entity.Passenger;
import com.session.three.fly.Fly.Model.Payload.ChangeDatesPayload;
import com.session.three.fly.Fly.Model.Payload.PassengerPayload;
import com.session.three.fly.Fly.Service.AirplaneService;
import com.session.three.fly.Fly.Service.FlyService;
import com.session.three.fly.Fly.Service.PassengerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class RestFlyControllerTest {

    @InjectMocks
    RestFlyController appController;

    @Mock
    FlyService flyService;

    @Mock
    AirplaneService airplaneService;

    @Mock
    PassengerService passengerService;

    //prueba de metodo post
    @Test
    void createFly() {
        Fly fly = mock(Fly.class);
        when(this.appController.createfly(fly)).thenReturn(fly);
        this.appController.createfly(fly);
        verify(this.flyService, times(1)).createNewFly(fly);
    }

    //prueba de metodo get
    @Test
    void getAirplaneByName(){
        String name = "Ang";
        Airplane airplane = mock(Airplane.class);
        when(this.appController.getAirplaneByName(name)).thenReturn(airplane);
        this.appController.getAirplaneByName(name);
        verify(this.airplaneService, times(1)).findAirplaneByName(name);
    }

    //COMO PROBAR ESTE????
    @Test
    void createPassenger(){
        Fly fly = mock(Fly.class);
        Airplane airplane1 = new Airplane("Ang", "marca", "modelo", 10);
        Passenger passenger = new Passenger();
        passenger.setFly(fly);
        passenger.setAirplane(airplane1);
        PassengerPayload payload = new PassengerPayload("nombre", 12345, "1A", "QA", "Ang" );
        when(this.airplaneService.findAirplaneByName(airplane1.getName())).thenReturn(airplane1);
        when(this.flyService.getFlyByCode(payload.getCode())).thenReturn(fly);
        doNothing().when(this.passengerService).createPassenger(passenger);
        when(this.appController.createNewPassenger(payload)).thenReturn(payload);

        this.appController.createNewPassenger(payload);
        verify(this.passengerService, times(1)).createPassenger(passenger);
    }

    //prueba de metodo Put
    @Test
    void changeDates(){
        ChangeDatesPayload changeDatesPayload = mock(ChangeDatesPayload.class);
        when(this.appController.changeDates(changeDatesPayload)).thenReturn(true);
        this.appController.changeDates(changeDatesPayload);
        verify(this.flyService, times(1)).changeDates(changeDatesPayload.getDeparture(), changeDatesPayload.getArraving(), changeDatesPayload.getCode());
    }
}
