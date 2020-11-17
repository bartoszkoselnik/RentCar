package com.workspace.rentcar.controller;

import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dto.RcCarDTO;
import com.workspace.rentcar.service.RcCarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private RcCarManager rcCars;

    @Autowired
    public CarApi(RcCarManager rcCar) {
        this.rcCars = rcCar;
    }

    @GetMapping("/all")
    public Iterable<RcCar> getAll() {
        return rcCars.findAll();
    }

    @GetMapping("/allv2")
    @ResponseBody
    public List<RcCarDTO> getAllMapper() {
        List <RcCarDTO> car = rcCars.getAllCarsMapper();
        return car;
    }

    @GetMapping
    public Optional<RcCar> getById(@RequestParam Long index) {
        return rcCars.findById(index);
    }

    @PostMapping
    public RcCar addCar(@RequestBody RcCar rcCar) {
        return rcCars.save(rcCar);
    }

    @PutMapping
    public RcCar updateCar(@RequestBody RcCar rcCar) {
        return rcCars.updateCar(rcCar);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long index) {
        rcCars.deleteById(index);
    }

    //    @PostMapping
//    public RcCar addCar() {
//
//    return rcCars.save(new RcCar("Hyundai", "C30", "Red", "sedan", 70,null ,
//       new RcEngine("RRR4567","Diesel",3.0F,455,"T","Automatic","AWD" )));
//    }
}
