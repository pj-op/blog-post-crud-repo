package com.blogpost.repository;

import com.blogpost.entities.BlogPost;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {

    @Modifying
    @Transactional
    @Query(value = "update blog_post b set b.publication_date=:publicationDate, b.author=:author, b.content=:content, b.title=:title where b.id=:blogPostId", nativeQuery = true)
    void updateBlogPostById(String author, String title, String content, Date publicationDate, Integer blogPostId);
}
