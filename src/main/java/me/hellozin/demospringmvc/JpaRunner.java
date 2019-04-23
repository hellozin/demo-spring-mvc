package me.hellozin.demospringmvc;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager; /* JPA 의 핵심 */

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /* Database 에 독립적 */
        Post post = new Post();
        post.setTitle("JPA");
        entityManager.persist(post);

        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);
        
    }

}
