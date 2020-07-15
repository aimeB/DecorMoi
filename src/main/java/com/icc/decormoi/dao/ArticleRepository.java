package com.icc.decormoi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icc.decormoi.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
