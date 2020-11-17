package com.workspace.rentcar.dto;

import com.workspace.rentcar.dao.entity.RcCar;
import java.util.Date;
import java.util.Set;

public class RcOrderDTO {
    private Long idRcOrder;
    private Float finalPrice;
    private Date orderDate;
    private Date startDate;
    private Date endDate;
    private Date returnDate;
    private Set<RcCarDTO> idRcCars;

    public Long getIdRcOrder() {
        return idRcOrder;
    }

    public void setIdRcOrder(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Set<RcCarDTO> getIdRcCars() {
        return idRcCars;
    }

    public void setIdRcCars(Set<RcCarDTO> idRcCars) {
        this.idRcCars = idRcCars;
    }
}
