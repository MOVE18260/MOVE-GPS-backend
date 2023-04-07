package dev.move.gps.repository;

import static dev.move.gps.entity.QRecord.record;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.move.gps.entity.RecordDto;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;

public class RecordRepositoryImpl implements RecordRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public RecordRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public RecordDto findMemberTotal(LocalDateTime from, LocalDateTime to) {
        return jpaQueryFactory
                .select(Projections.constructor(RecordDto.class,
                        record.step.sum(),
                        record.distance.sum()))
                .from(record)
                .where(record.dateTime.between(from, to))
                .fetchOne();
    }
}
