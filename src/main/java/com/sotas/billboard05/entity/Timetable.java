package com.sotas.billboard05.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "timetables")
public class Timetable {
    public static class Status{
        public static final int OPEN=0;
        public static final int DEFAULT=100;
        public static final int CLOSE=1000;
    }
    @Id @GeneratedValue
    private int id;
    @Column(name = "side_id")
    private int sideId;
    private int surface;
    private int month;
    private int year;
    private BigDecimal rent;
    private int status;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    public Timetable() {
    }

    public Timetable(int sideId, int surface, int month, int year, BigDecimal rent, int status) {
        this.sideId = sideId;
        this.surface = surface;
        this.month = month;
        this.year = year;
        this.rent = rent;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timetable timetable = (Timetable) o;

        if (id != timetable.id) return false;
        if (sideId != timetable.sideId) return false;
        if (surface != timetable.surface) return false;
        if (month != timetable.month) return false;
        if (year != timetable.year) return false;
        if (status != timetable.status) return false;
        if (rent != null ? !rent.equals(timetable.rent) : timetable.rent != null) return false;
        return createDate != null ? createDate.equals(timetable.createDate) : timetable.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sideId;
        result = 31 * result + surface;
        result = 31 * result + month;
        result = 31 * result + year;
        result = 31 * result + (rent != null ? rent.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "id=" + id +
                ", sideId=" + sideId +
                ", surface=" + surface +
                ", month=" + month +
                ", year=" + year +
                ", rent=" + rent +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSideId() {
        return sideId;
    }

    public void setSideId(int sideId) {
        this.sideId = sideId;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
