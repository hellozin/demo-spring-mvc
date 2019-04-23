package me.hellozin.demospringmvc;

import lombok.extern.java.Log;

import javax.persistence.*;

@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    /* 기본값은 바로 엔티티 정보를 가져온다.*/
    private Post post;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
