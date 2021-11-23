package com.decormoi.app.service;

import com.decormoi.app.domain.Comment;
<<<<<<< HEAD

import com.decormoi.app.domain.Salle;
import com.decormoi.app.repository.CommentRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import com.decormoi.app.repository.CommentRepository;

import com.sun.org.slf4j.internal.LoggerFactory;
=======
import com.decormoi.app.domain.Salle;
import com.decormoi.app.repository.CommentRepository;
import java.util.List;
import java.util.Optional;
>>>>>>> 5fd55b5 (modification backend)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD
import sun.jvm.hotspot.debugger.Page;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
=======
>>>>>>> 5fd55b5 (modification backend)

/**
 * Service Implementation for managing {@link Comment}.
 */
@Service
@Transactional
public class CommentService {

<<<<<<< HEAD
=======
    private final Logger log = LoggerFactory.getLogger(CommentService.class);
>>>>>>> 5fd55b5 (modification backend)

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Save a comment.
     *
     * @param comment the entity to save.
     * @return the persisted entity.
     */
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * Get all the comments.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Comment> findAll(Pageable pageable) {
        log.debug("Request to get all Salles");
        return commentRepository.findAll(pageable);
    }

    /**
     * Get all comments
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public List<Comment> findAllByBlogId(Long id) {
        return commentRepository.findCommentByBlogId(id);
    }

    /**
     * Get one comment by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Comment> findOne(Long id) {
        return commentRepository.findById(id);
    }
<<<<<<< HEAD

=======
>>>>>>> 5fd55b5 (modification backend)
}
