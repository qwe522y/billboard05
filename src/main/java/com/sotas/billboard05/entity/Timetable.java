package com.sotas.billboard05.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "timetables")
public class Timetable {
    @Id @GeneratedValue
    private int id;
    @Column(name = "billboard_id")
    private int billboardId;
    private int side;
    private int surface;
    private int month;
    private int year;
    private BigDecimal rent;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Timetable() {
    }

    public Timetable(int billboardId, int side, int surface, int year, int month, BigDecimal rent) {
        this.billboardId = billboardId;
        this.side = side;
        this.surface = surface;
        this.month = month;
        this.year = year;
        this.rent = rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timetable)) return false;

        Timetable timetable = (Timetable) o;

        if (id != timetable.id) return false;
        if (billboardId != timetable.billboardId) return false;
        if (side != timetable.side) return false;
        if (surface != timetable.surface) return false;
        if (month != timetable.month) return false;
        if (year != timetable.year) return false;
        if (rent != null ? !rent.equals(timetable.rent) : timetable.rent != null) return false;
        return createDate != null ? createDate.equals(timetable.createDate) : timetable.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + billboardId;
        result = 31 * result + side;
        result = 31 * result + surface;
        result = 31 * result + month;
        result = 31 * result + year;
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", billboardId=" + billboardId +
                ", side=" + side +
                ", surface=" + surface +
                ", month=" + month +
                ", year=" + year +
                ", rent=" + rent +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public int getBillboardId() {
        return billboardId;
    }

    public void setBillboardId(int billboardId) {
        this.billboardId = billboardId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
