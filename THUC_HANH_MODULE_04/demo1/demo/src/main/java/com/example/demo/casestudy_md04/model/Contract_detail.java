package com.example.demo.casestudy_md04.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class Contract_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_detail_id;
    private int contract_id;
    private int attach_service_id;
    private int quantity;

    @ManyToOne(targetEntity = Contract.class)
    private Contract contract;


    public Contract_detail() {
    }

    public Contract_detail(int contract_detail_id, int contract_id, int attach_service_id, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service_id = attach_service_id;
        this.quantity = quantity;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(int attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
