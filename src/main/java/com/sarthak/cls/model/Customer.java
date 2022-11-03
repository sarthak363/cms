package com.sarthak.cls.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("ID")
    private int costumerID;
    @Column
    @JsonProperty("FirstName")
    private String costumerFirstName;
    @Column
    @JsonProperty("LastName")
    private String CostumerLastName;
    @Column
    @JsonProperty("Mail")
    private String email;


    public Customer() {
    }

    public Customer(int costumerID, String costumerFirstName, String costumerLastName, String email) {
        this.costumerID = costumerID;
        this.costumerFirstName = costumerFirstName;
        this.CostumerLastName = costumerLastName;
        this.email = email;
    }

    public int getCostumerID() {
        return costumerID;
    }

    public void setCostumerID(int costumerID) {
        this.costumerID = costumerID;
    }

    public String getCostumerFirstName() {
        return costumerFirstName;
    }


    public void setCostumerFirstName(String costumerFirstName) {
        this.costumerFirstName = costumerFirstName;
    }

    public String getCostumerLastName() {
        return CostumerLastName;
    }

    public void setCostumerLastName(String costumerLastName) {
        CostumerLastName = costumerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}