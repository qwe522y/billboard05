package com.sotas.billboard05.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {
    @Id @GeneratedValue
    private int id;
    private String name;
    private String location;
}
