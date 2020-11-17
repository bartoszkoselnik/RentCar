package com.workspace.rentcar.service;

import com.workspace.rentcar.dao.repository.RcCarRepo;
import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dto.RcCarDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RcCarManager {

    @Autowired
    private ModelMapper modelMapper;

    private RcCarRepo rcCarRepo;

    @Autowired
    public RcCarManager(RcCarRepo rcCarRepo) {
        this.rcCarRepo = rcCarRepo;
    }



    public Iterable<RcCar> findAll() {
        return rcCarRepo.findAll();
    }

    public Optional<RcCar> findById(Long id) {
        return rcCarRepo.findById(id);
    }

    public RcCar save(RcCar rcCar) {
        return rcCarRepo.save(rcCar);
    }

    public RcCar updateCar(RcCar rcCar) {
        return rcCarRepo.save(rcCar);
    }

    public void deleteById(Long id) {
        rcCarRepo.deleteById(id);
    }

    public List<RcCarDTO> getAllCarsMapper() {
        return ((List<RcCar>) rcCarRepo.findAll()).stream().map(this::convertToRcCarDTO)
                .collect(Collectors.toList());
    }

    private RcCarDTO convertToRcCarDTO(RcCar rcCar) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        RcCarDTO rcCarDTO = modelMapper.map(rcCar, RcCarDTO.class);
        return rcCarDTO;
    }
}
