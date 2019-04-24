package me.hellozin.demospringmvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
// JpaRepository 를 상속받음으로써 아래의 코드가 생략 가능해진다.
////    @Autowired /*  */
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public Post add(Post post) {
//        entityManager.persist(post);
//        return post;
//    }
//
//    public void delete(Post post) {
//        entityManager.remove(post);
//    }
//
//    public List<Post> findAll() {
//        return entityManager.createQuery("SELECT p FROM Post As p", Post.class).getResultList();
//    }

}
