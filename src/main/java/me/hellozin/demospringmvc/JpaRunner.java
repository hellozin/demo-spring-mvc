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

//    @Transactional
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
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }

}
