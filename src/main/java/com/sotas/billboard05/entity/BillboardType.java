package com.sotas.billboard05.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billboard_types")
public class BillboardType {
    @Id @GeneratedValue
    private int id;
    private String name;
    private int surface;

    public BillboardType() {
    }

    public BillboardType(String name, int surface) {
        this.name = name;
        this.surface = surface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillboardType)) return false;

        BillboardType that = (BillboardType) o;

        if (id != that.id) return false;
        if (surface != that.surface) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + surface;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }
}
