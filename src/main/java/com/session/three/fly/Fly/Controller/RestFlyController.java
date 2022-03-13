package com.session.three.fly.Fly.Controller;

import com.session.three.fly.Fly.Model.Entity.Airplane;
import com.session.three.fly.Fly.Model.Entity.Fly;
import com.session.three.fly.Fly.Model.Entity.Passenger;
import com.session.three.fly.Fly.Model.Payload.ChangeDatesPayload;
import com.session.three.fly.Fly.Model.Payload.PassengerPayload;
import com.session.three.fly.Fly.Service.AirplaneService;
import com.session.three.fly.Fly.Service.FlyService;
import com.session.three.fly.Fly.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api/fly/1.0")
public class RestFlyController {
    
    @Autowired
    private FlyService flyService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private PassengerService passengerService;


    @GetMapping("/prueba")
    public boolean prub(){
        System.out.printf("hola");
        return true;
    }

    @PostMapping("/createFly")
    @ResponseStatus(HttpStatus.CREATED)
    public Fly createfly(@RequestBody Fly fly) {
        return this.flyService.createNewFly(fly);
    }

    @PostMapping("/insertNewAirplane")
    @ResponseStatus(HttpStatus.CREATED)
    public Airplane createAirplane(@RequestBody Airplane airplane){
        return this.airplaneService.createAirplane(airplane);
    }

    @GetMapping("/getAirplaneByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Airplane getAirplaneByName(@PathVariable String name){
        return this.airplaneService.findAirplaneByName(name);
    }

    @GetMapping("/getFlyByCode/{flyCode}")
    @ResponseStatus(HttpStatus.OK)
    public Fly getFlyByCode(@PathVariable String flyCode){
        return this.flyService.getFlyByCode(flyCode);
    }

    @PostMapping("/insertNewPassenger")
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerPayload createNewPassenger(@RequestBody PassengerPayload passengerPayload){
        Airplane airplane = this.airplaneService.findAirplaneByName(passengerPayload.getNameAirplane());
        Integer seats = airplane.getSeatQuantity() - 1;
        airplane.setSeatQuantity(seats);

        Fly fly = this.flyService.getFlyByCode(passengerPayload.getCode());
        Passenger passenger = new Passenger();

        passenger.setFly(fly);
        passenger.setAirplane(airplane);
        passenger.setDocument(passengerPayload.getDocument());
        passenger.setName(passengerPayload.getName());
        passenger.setSeatNumber(passengerPayload.getSeatNumber());

        this.passengerService.createPassenger(passenger);

        return passengerPayload;
    }

    @GetMapping("/getAllPassenger")
    @ResponseStatus(HttpStatus.OK)
    public List<Passenger> allPassngers(){
        List<Passenger> passangerList = this.passengerService.getAllPassanger();

        return StreamSupport.stream(passangerList.spliterator(), false)
                .collect(Collectors.toList());
    }

    @PutMapping("/modifyDateFly")
    @ResponseStatus(HttpStatus.OK)
    public Boolean changeDates(@RequestBody ChangeDatesPayload changes){
        return this.flyService.changeDates(changes.getDeparture(), changes.getArraving(), changes.getCode());
    }
}
