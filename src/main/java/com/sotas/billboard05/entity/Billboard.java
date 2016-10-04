package com.sotas.billboard05.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
    @Column(name = "side_num")
    private int sideNum; // кол-во сторон для размещения рекламы
    @Column(name = "surface_num_per_side")
    private int surfaceNumPerSide; // кол-во рекламных поверхностей на каждой стороне
    private BigDecimal rent;
    private String location;
    @Column(name = "owner_id")
    private int ownerId;
    @Column(name = "agent_id")
    private int agentId;
    private String comment;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Billboard() {
    }

    public Billboard(int cityId, String address, int typeId, int formatId, boolean light, int sideNum, int surfaceNumPerSide, BigDecimal rent, String location, int ownerId, int agentId, String comment) {
        this.cityId = cityId;
        this.address = address;
        this.typeId = typeId;
        this.formatId = formatId;
        this.light = light;
        this.sideNum = sideNum;
        this.surfaceNumPerSide = surfaceNumPerSide;
        this.rent = rent;
        this.location = location;
        this.ownerId = ownerId;
        this.agentId = agentId;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Billboard)) return false;

        Billboard billboard = (Billboard) o;

        if (id != billboard.id) return false;
        if (cityId != billboard.cityId) return false;
        if (typeId != billboard.typeId) return false;
        if (formatId != billboard.formatId) return false;
        if (light != billboard.light) return false;
        if (sideNum != billboard.sideNum) return false;
        if (surfaceNumPerSide != billboard.surfaceNumPerSide) return false;
        if (ownerId != billboard.ownerId) return false;
        if (agentId != billboard.agentId) return false;
        if (address != null ? !address.equals(billboard.address) : billboard.address != null) return false;
        if (rent != null ? !rent.equals(billboard.rent) : billboard.rent != null) return false;
        if (location != null ? !location.equals(billboard.location) : billboard.location != null) return false;
        if (comment != null ? !comment.equals(billboard.comment) : billboard.comment != null) return false;
        if (createDate != null ? !createDate.equals(billboard.createDate) : billboard.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cityId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + typeId;
        result = 31 * result + formatId;
        result = 31 * result + (light ? 1 : 0);
        result = 31 * result + sideNum;
        result = 31 * result + surfaceNumPerSide;
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + ownerId;
        result = 31 * result + agentId;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
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
                ", sideNum=" + sideNum +
                ", surfaceNumPerSide=" + surfaceNumPerSide +
                ", rent=" + rent +
                ", location='" + location + '\'' +
                ", ownerId=" + ownerId +
                ", agentId=" + agentId +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
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

    public int getSideNum() {
        return sideNum;
    }

    public void setSideNum(int sideNum) {
        this.sideNum = sideNum;
    }

    public int getSurfaceNumPerSide() {
        return surfaceNumPerSide;
    }

    public void setSurfaceNumPerSide(int surfaceNum) {
        this.surfaceNumPerSide = surfaceNum;
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

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
