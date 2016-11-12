package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.Billboard;
import com.sotas.billboard05.entity.BillboardSide;
import com.sotas.billboard05.entity.Contract;
import com.sotas.billboard05.entity.Timetable;

public class ContractDto {
    private Contract e;
    private Timetable timetable;
    private Billboard billboard;
    private BillboardSide billboardSide;

    public ContractDto(Contract e, Timetable timetable, Billboard billboard, BillboardSide billboardSide) {
        this.e = e;
        this.timetable = timetable;
        this.billboard = billboard;
        this.billboardSide = billboardSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractDto)) return false;

        ContractDto that = (ContractDto) o;

        if (e != null ? !e.equals(that.e) : that.e != null) return false;
        if (timetable != null ? !timetable.equals(that.timetable) : that.timetable != null) return false;
        if (billboard != null ? !billboard.equals(that.billboard) : that.billboard != null) return false;
        return billboardSide != null ? billboardSide.equals(that.billboardSide) : that.billboardSide == null;

    }

    @Override
    public int hashCode() {
        int result = e != null ? e.hashCode() : 0;
        result = 31 * result + (timetable != null ? timetable.hashCode() : 0);
        result = 31 * result + (billboard != null ? billboard.hashCode() : 0);
        result = 31 * result + (billboardSide != null ? billboardSide.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContractDto{" +
                "e=" + e +
                ", timetable=" + timetable +
                ", billboard=" + billboard +
                ", billboardSide=" + billboardSide +
                '}';
    }

    public Contract getE() {
        return e;
    }

    public void setE(Contract e) {
        this.e = e;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    public Billboard getBillboard() {
        return billboard;
    }

    public void setBillboard(Billboard billboard) {
        this.billboard = billboard;
    }

    public BillboardSide getBillboardSide() {
        return billboardSide;
    }

    public void setBillboardSide(BillboardSide billboardSide) {
        this.billboardSide = billboardSide;
    }
}
