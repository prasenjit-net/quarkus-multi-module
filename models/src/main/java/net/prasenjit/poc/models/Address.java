package net.prasenjit.poc.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Address extends PanacheEntity {
    public String street;
    public String city;
    public String state;
    public String zip;
}
