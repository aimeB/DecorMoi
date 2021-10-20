package com.decormoi.app.repository;

import com.decormoi.app.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data SQL repository for the Comment entity.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {
    //@Query("select comment from Comment comment where comment.blogId =:id")
    List<Comment> findCommentByBlogId(Long id);

}
