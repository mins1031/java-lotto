package temp;
/*
import co.myfair.admin.hall.dto.request.HallSearchRequest;
import co.myfair.core.exhibition.subexpo.model.hall.Hall;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static co.myfair.core.exhibition.subexpo.model.hall.QHall.hall;
import static co.myfair.core.exhibition.subexpo.model.hall.QHallSearchTag.hallSearchTag;

@RequiredArgsConstructor
@Repository
public class HallQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public Page<Hall> searchHall(HallSearchRequest hallSearchRequest, Pageable pageable) {
        QueryResults<Hall> hallQueryResults = jpaQueryFactory.selectFrom(hall)
                .leftJoin(hall.hallSearchTags, hallSearchTag).fetchJoin()
                .where(hallSearchRequest.getType().getFunction().tony(hallSearchRequest.getKeyword()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(hallQueryResults.getResults(), pageable, hallQueryResults.getTotal());
    }

    private BooleanExpression eqSearchType(HallSearchRequest hallSearchRequest) {
        HallSearchType hallSearchType = hallSearchRequest.getType();

        if (hallSearchType == HallSearchType.NAME) {
            return hall.name.eq(hallSearchRequest.getKeyword());
        }

        if (hallSearchType == HallSearchType.LOCATION) {
            return hall.location.eq(hallSearchRequest.getKeyword());
        }

        if (hallSearchType == HallSearchType.NUM) {
            return hall.num.eq(Long.parseLong(hallSearchRequest.getKeyword()));
        }

        if (hallSearchType == HallSearchType.COUNTRY) {
            return hall.country.eq(hallSearchRequest.getKeyword());
        }

        return null;
    }
}

 */
