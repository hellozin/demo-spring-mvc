package me.hellozin.demospringmvc;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; /* JPA 의 핵심 */

//    @Transactional /* 이건 왜 쓰지? */
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        Account account = new Account();
//        account.setUsername("hellozin");
//        account.setPassword("jpa");
//        entityManager.persist(account);
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("hellozin");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data JPA");

//        account.getStudies().add(study);
//        study.setOwner(account);
        account.addStudy(study);    // 일반적인 사용법

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }

}
