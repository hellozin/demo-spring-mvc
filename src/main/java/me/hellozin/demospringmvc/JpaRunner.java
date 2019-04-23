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
        /* Transient 상태: JPA가 모르는 상태 */
        Account account = new Account();
        account.setUsername("hellozin");
        account.setPassword("jpa");

        Study study = new Study();
        study.setName("Spring Data JPA");
        /**/


//        account.getStudies().add(study);
//        study.setOwner(account);
        account.addStudy(study);    // 일반적인 사용법

        Session session = entityManager.unwrap(Session.class);
        session.save(account); /* Persistent 상태: JPA가 관리중인 상태, 바로 DB에 들어가는 것은 아님 */
        session.save(study);

        Account hellozin = session.load(Account.class, account.getId());
        /* Persistent 상태에 해주는 일 중 1개: 1차 캐시, hellozin 은 select 쿼리가 발생하지 않는다.*/
        hellozin.setUsername("hellozun"); /* 불필요한 select 하지 않고 update, Dirty Checking, Write Behind*/
        hellozin.setUsername("hellozin"); /* 이러면 update 도 이루어지지 않음 */
    }

}
