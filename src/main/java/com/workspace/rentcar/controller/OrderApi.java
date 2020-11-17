package com.workspace.rentcar.controller;

import com.workspace.rentcar.dao.entity.RcOrder;
import com.workspace.rentcar.dto.RcCarDTO;
import com.workspace.rentcar.dto.RcOrderDTO;
import com.workspace.rentcar.service.RcOrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    private RcOrderManager rcOrderManager;

    @Autowired
    public OrderApi(RcOrderManager rcOrderManager) {
        this.rcOrderManager = rcOrderManager;
    }

    @GetMapping("/all")
    public Iterable<RcOrder> getAll() {
        return rcOrderManager.getAll();
    }

    @GetMapping("/allv2")
    @ResponseBody
    public List<RcOrderDTO> getAllMapper() {
        List <RcOrderDTO> order = rcOrderManager.getAllOrdersMapper();
        return order;
    }

    @GetMapping
    public Optional<RcOrder> getById(@RequestParam Long index){
        return rcOrderManager.findById(index);
    }

    @PostMapping
    public RcOrder save(@RequestBody RcOrder rcOrder) {
        return rcOrderManager.save(rcOrder);
    }

    @PutMapping
    public RcOrder updateOrder(@RequestBody RcOrder rcOrder) {
        return rcOrderManager.updateOrder(rcOrder);
    }
}
