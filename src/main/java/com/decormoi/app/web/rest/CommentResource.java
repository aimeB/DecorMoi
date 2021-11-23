package com.decormoi.app.web.rest;

import com.decormoi.app.domain.Comment;
import com.decormoi.app.domain.EventLocation;
import com.decormoi.app.repository.CommentRepository;
import com.decormoi.app.repository.EventLocationRepository;
import com.decormoi.app.service.CommentService;
import com.decormoi.app.service.EventLocationService;
import com.decormoi.app.service.SalleQueryService;
import com.decormoi.app.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing {@link Comment}.
 */
@RestController
@RequestMapping("/api")
public class CommentResource {

    private final Logger log = LoggerFactory.getLogger(CommentResource.class);

    private static final String ENTITY_NAME = "comment";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CommentService commentService;



    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }




    /**
     * {@code POST  /comments} : Create a new comment
     *
     * @param comment the event location to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new salle, or with status {@code 400 (Bad Request)} if the salle has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/comments")
    public ResponseEntity<Comment> createComment(@Valid @RequestBody Comment comment) throws URISyntaxException {
        if (comment.getId() != null) {
            throw new BadRequestAlertException("A new comment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Comment result = commentService.save(comment);
        return ResponseEntity
            .created(new URI("/api/comments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/comments/{id}")
    public ResponseEntity<List<Comment>> getAllComment(@PathVariable Integer id, Pageable pageable) {
        Page<Comment> comments = commentService.findAll(pageable);
        List<Comment> commentList = comments.stream().filter(comment -> comment.getBlogId()==id).collect(Collectors.toList());
        return ResponseEntity.ok().body(commentList);
    }




}
