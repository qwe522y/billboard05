package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.*;

public class BillboardDto {
    private Billboard e;
    private Owner owner;
    private Agent agent;
    private City city;
    private BillboardType type;
    private BillboardFormat format;

    public BillboardDto(Billboard e, Owner owner, Agent agent, City city, BillboardType type, BillboardFormat format) {
        this.e = e;
        this.owner = owner;
        this.agent = agent;
        this.city = city;
        this.type = type;
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillboardDto)) return false;

        BillboardDto that = (BillboardDto) o;

        if (e != null ? !e.equals(that.e) : that.e != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (agent != null ? !agent.equals(that.agent) : that.agent != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = e != null ? e.hashCode() : 0;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (agent != null ? agent.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillboardDto{" +
                "e=" + e +
                ", owner=" + owner +
                ", agent=" + agent +
                ", city=" + city +
                ", type=" + type +
                ", format=" + format +
                '}';
    }

    public Billboard getE() {
        return e;
    }

    public void setE(Billboard e) {
        this.e = e;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BillboardType getType() {
        return type;
    }

    public void setType(BillboardType type) {
        this.type = type;
    }

    public BillboardFormat getFormat() {
        return format;
    }

    public void setFormat(BillboardFormat format) {
        this.format = format;
    }
}
