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
        Post post = new Post();
        post.setTitle("Spring Data JPA");

        Comment comment = new Comment();
        comment.setComment("soon");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("me too");
        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);
        Post getpost = session.get(Post.class, 1l);
        session.remove(getpost);

    }

}
