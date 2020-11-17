package com.workspace.rentcar.service;

import com.workspace.rentcar.dao.entity.RcCar;
import com.workspace.rentcar.dao.repository.RcOrderRepo;
import com.workspace.rentcar.dao.entity.RcOrder;
import com.workspace.rentcar.dto.RcCarDTO;
import com.workspace.rentcar.dto.RcOrderDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RcOrderManager {

    private RcOrderRepo rcOrderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public RcOrderManager(RcOrderRepo rcOrderRepo) {
        this.rcOrderRepo = rcOrderRepo;
    }

    public Iterable<RcOrder> getAll() {
        return rcOrderRepo.findAll();
    }

    public Optional<RcOrder> findById(Long id) {
        return rcOrderRepo.findById(id);
    }

    public RcOrder save(RcOrder rcOrder) {
        return rcOrderRepo.save(rcOrder);
    }

    public RcOrder updateOrder(RcOrder rcOrder) {
        return  rcOrderRepo.save(rcOrder);
    }


    public List<RcOrderDTO> getAllOrdersMapper() {
        return ((List<RcOrder>) rcOrderRepo.findAll()).stream().map(this::convertToRcOrderDTO)
                .collect(Collectors.toList());
    }

    private RcOrderDTO convertToRcOrderDTO(RcOrder rcOrder) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        RcOrderDTO rcOrderDTO = modelMapper.map(rcOrder, RcOrderDTO.class);
        return rcOrderDTO;
    }
}

