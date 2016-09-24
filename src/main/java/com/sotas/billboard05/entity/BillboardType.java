package com.sotas.billboard05.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billboard_type")
public class BillboardType {
    @Id
    private int id;
    private int name;
    private int surface;
}
