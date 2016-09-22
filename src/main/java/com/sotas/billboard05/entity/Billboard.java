package com.sotas.billboard05.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "billboards")
public class Billboard {
    @Id @GeneratedValue
    private int id;
    private String name;
    private int city;
    private String address;
    private int type;
    private boolean light;
    private BigDecimal rent;
    private String location;
    @Column(name = "owner_id")
    private int ownerId;
    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Billboard(int city, String address, int type, boolean light, BigDecimal rent, String location, int ownerId) {
        this.city = city;
        this.address = address;
        this.type = type;
        this.light = light;
        this.rent = rent;
        this.location = location;
        this.ownerId = ownerId;
    }

    public Billboard() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Billboard billboard = (Billboard) o;

        if (id != billboard.id) return false;
        if (city != billboard.city) return false;
        if (type != billboard.type) return false;
        if (light != billboard.light) return false;
        if (ownerId != billboard.ownerId) return false;
        if (name != null ? !name.equals(billboard.name) : billboard.name != null) return false;
        if (address != null ? !address.equals(billboard.address) : billboard.address != null) return false;
        if (rent != null ? !rent.equals(billboard.rent) : billboard.rent != null) return false;
        if (location != null ? !location.equals(billboard.location) : billboard.location != null) return false;
        return createDate.equals(billboard.createDate);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + city;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (light ? 1 : 0);
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + ownerId;
        result = 31 * result + createDate.hashCode();
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

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
