package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.querydsl.entity.Hello;
import study.querydsl.entity.QHello;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class QuerydslStudyApplicationTests {

    @Autowired //스프링에서 지원
    // @PersistenceContext 자바 표준 스펙
    EntityManager em;

    @Test
    void contextLoads() {
        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        QHello qHello = QHello.hello;

        Hello result = jpaQueryFactory
                .selectFrom(qHello)
                .fetchOne();

        assertThat(hello).isEqualTo(result);
        assertThat(result.getId()).isEqualTo(hello.getId());
    }

}
