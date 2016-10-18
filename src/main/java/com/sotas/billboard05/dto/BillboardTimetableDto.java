package com.sotas.billboard05.dto;

import com.sotas.billboard05.entity.BillboardSide;

import java.util.List;

public class BillboardTimetableDto {
    private List<Side> sides;

    public BillboardTimetableDto(List<Side> sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "BillboardTimetableDto{" +
                "sides=" + sides +
                '}';
    }

    public static class Side {
        private BillboardSide e;
        private List<Timetable> timetables;

        public Side(BillboardSide e, List<Timetable> timetables) {
            this.e = e;
            this.timetables = timetables;
        }

        @Override
        public String toString() {
            return "Side{" +
                    "e=" + e +
                    ", timetables=" + timetables +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Side)) return false;

            Side side = (Side) o;

            if (e != null ? !e.equals(side.e) : side.e != null) return false;
            return timetables != null ? timetables.equals(side.timetables) : side.timetables == null;

        }

        @Override
        public int hashCode() {
            int result = e != null ? e.hashCode() : 0;
            result = 31 * result + (timetables != null ? timetables.hashCode() : 0);
            return result;
        }

        public BillboardSide getE() {
            return e;
        }

        public List<Timetable> getTimetables() {
            return timetables;
        }
    }

    public static class Timetable {
        private int surfaceNum;
        private int year;
        private int month;
        private int rent;

        public Timetable(int surfaceNum, int year, int month, int rent) {
            this.surfaceNum = surfaceNum;
            this.year = year;
            this.month = month;
            this.rent = rent;
        }

        @Override
        public String toString() {
            return "Surface{" +
                    "surfaceNum=" + surfaceNum +
                    ", year=" + year +
                    ", month=" + month +
                    ", rent=" + rent +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Timetable)) return false;

            Timetable timetable = (Timetable) o;

            if (surfaceNum != timetable.surfaceNum) return false;
            if (year != timetable.year) return false;
            if (month != timetable.month) return false;
            return rent == timetable.rent;

        }

        @Override
        public int hashCode() {
            int result = surfaceNum;
            result = 31 * result + year;
            result = 31 * result + month;
            result = 31 * result + rent;
            return result;
        }

        public int getSurfaceNum() {
            return surfaceNum;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getRent() {
            return rent;
        }
    }
}
