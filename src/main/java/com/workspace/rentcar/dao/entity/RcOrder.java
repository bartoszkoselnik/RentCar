package com.workspace.rentcar.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class RcOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_order")
    @SequenceGenerator(name = "id_sequence_order", sequenceName = "RC_ORDER_SEQ1", allocationSize = 0)
    @Column(name = "ID_RC_ORDER")
    private Long idRcOrder;
    @Column
    private Long idRcCustomer;
    @Column
    private Long idRcEmployee;
    @Column
    private Float contractPrice;
    @Column
    private Float finalPrice;
    @Column
    private Date orderDate;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private Date returnDate;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "RC_ORDER_RC_CAR", joinColumns = @JoinColumn(name = "ID_RC_ORDER"), inverseJoinColumns = @JoinColumn(name = "ID_RC_CAR"))

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_order_car")
    @SequenceGenerator(name = "id_sequence_order_car", sequenceName = "RC_ORDER_TO_RC_CAR_SEQ1",allocationSize = 0)
    private Set<RcCar> idRcCars;

    private RcOrder() {
    }

    public RcOrder(Long idRcOrder, Long idRcCustomer, Long idRcEmployee, Float contractPrice, Float finalPrice, Date orderDate, Date startDate, Date endDate, Date returnDate) {
        this.idRcOrder = idRcOrder;
        this.idRcCustomer = idRcCustomer;
        this.idRcEmployee = idRcEmployee;
        this.contractPrice = contractPrice;
        this.finalPrice = finalPrice;
        this.orderDate = orderDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
        this.idRcCars = new HashSet<>();
    }

    public Long getIdRcOrder() {
        return idRcOrder;
    }

    public void setIdRcOrder(Long idRcOrder) {
        this.idRcOrder = idRcOrder;
    }

    public Long getIdRcCustomer() {
        return idRcCustomer;
    }

    public void setIdRcCustomer(Long idRcCustomer) {
        this.idRcCustomer = idRcCustomer;
    }

    public Long getIdRcEmployee() {
        return idRcEmployee;
    }

    public void setIdRcEmployee(Long idRcEmployee) {
        this.idRcEmployee = idRcEmployee;
    }

    public Float getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Float contractPrice) {
        this.contractPrice = contractPrice;
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


    public Set<RcCar> getIdRcCars() {
        return idRcCars;
    }

    public void setIdRcCars(Set<RcCar> idRcCars) {
        this.idRcCars = idRcCars;
    }

}
