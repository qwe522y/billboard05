package com.sotas.billboard05.entity;

import javax.persistence.*;

@Entity
@Table(name = "billboards")
public class Billboard {
    @Id @GeneratedValue
    private int id;
    @Column(name = "city_id")
    private int cityId;
    private String address;
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "format_id")
    private int formatId;
    private boolean light;
    private String location;
    @Column(name = "owner_id")
    private int ownerId;
    @Column(name = "agent_id")
    private int agentId;

    public Billboard() {
    }

    public Billboard(int cityId, String address, int typeId, int formatId, boolean light, String location, int ownerId, int agentId) {
        this.cityId = cityId;
        this.address = address;
        this.typeId = typeId;
        this.formatId = formatId;
        this.light = light;
        this.location = location;
        this.ownerId = ownerId;
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "Billboard{" +
                "id=" + id +
                ", cityId=" + cityId +
                ", address='" + address + '\'' +
                ", typeId=" + typeId +
                ", formatId=" + formatId +
                ", light=" + light +
                ", location='" + location + '\'' +
                ", ownerId=" + ownerId +
                ", agentId=" + agentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Billboard billboard = (Billboard) o;

        if (id != billboard.id) return false;
        if (cityId != billboard.cityId) return false;
        if (typeId != billboard.typeId) return false;
        if (formatId != billboard.formatId) return false;
        if (light != billboard.light) return false;
        if (ownerId != billboard.ownerId) return false;
        if (agentId != billboard.agentId) return false;
        if (address != null ? !address.equals(billboard.address) : billboard.address != null) return false;
        return location != null ? location.equals(billboard.location) : billboard.location == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cityId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + typeId;
        result = 31 * result + formatId;
        result = 31 * result + (light ? 1 : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + ownerId;
        result = 31 * result + agentId;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
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

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
}
