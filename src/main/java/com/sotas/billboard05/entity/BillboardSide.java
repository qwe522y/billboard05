package com.sotas.billboard05.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "billboard_sides")
public class BillboardSide {
    @Id @GeneratedValue
    private int id;
    @Column(name = "billboard_id")
    private int billboardId;
    private String name;
    private BigDecimal rent;
    @Column(name = "surface_count")
    private int surfaceCount = 1;

    public BillboardSide() {
    }

    public BillboardSide(int billboardId, String name, BigDecimal rent, int surfaceCount) {
        this.billboardId = billboardId;
        this.name = name;
        this.rent = rent;
        this.surfaceCount = surfaceCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillboardSide that = (BillboardSide) o;

        if (id != that.id) return false;
        if (billboardId != that.billboardId) return false;
        if (surfaceCount != that.surfaceCount) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return rent != null ? rent.equals(that.rent) : that.rent == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + billboardId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + surfaceCount;
        return result;
    }

    @Override
    public String toString() {
        return "BillboardSide{" +
                "id=" + id +
                ", billboardId=" + billboardId +
                ", name='" + name + '\'' +
                ", rent=" + rent +
                ", surfaceCount=" + surfaceCount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBillboardId() {
        return billboardId;
    }

    public void setBillboardId(int billboardId) {
        this.billboardId = billboardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public int getSurfaceCount() {
        return surfaceCount;
    }

    public void setSurfaceCount(int surfaceCount) {
        this.surfaceCount = surfaceCount;
    }
}
