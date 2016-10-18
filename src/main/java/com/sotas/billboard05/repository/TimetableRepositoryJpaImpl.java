package com.sotas.billboard05.repository;

import com.sotas.billboard05.entity.Timetable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableRepositoryJpaImpl extends CrudRepositoryJpaImpl<Timetable, Integer> implements TimetableRepository {
    public TimetableRepositoryJpaImpl() {
        super(Timetable.class);
    }

    @Override
    public List<Timetable> getByBillboardSideAndBeginDate(int sideId, int year, int month) {
        return getEntityManager().createQuery(
                "SELECT e FROM Timetable e WHERE e.sideId=:sideId AND" +
                        " (e.year>:year OR (e.year=:year AND e.month>=:month))" +
                        " ORDER BY e.year, e.month", Timetable.class)
                .setParameter("sideId", sideId)
                .setParameter("year", year)
                .setParameter("month", month).getResultList();
    }
}
