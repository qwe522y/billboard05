package com.sotas.billboard05.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class BillboardOwner {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phone;
}
