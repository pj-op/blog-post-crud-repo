package com.blogpost.controller;

import com.blogpost.dtos.records.BlogPostRequestDto;
import com.blogpost.dtos.records.BlogPostResponseDto;
import com.blogpost.service.BlogPostService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogpost")
public class BlogPostController {

    BlogPostService blogPostService;

    BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPostResponseDto> createBlogPost(@RequestBody BlogPostRequestDto blogPostRequestDto) {
        BlogPostResponseDto responseDto = blogPostService.createBlogPost(blogPostRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPostResponseDto> readBlogPost(@PathVariable(name = "id") @Validated Integer blogId) {
        return ResponseEntity.ok(blogPostService.getBlogPost(blogId));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteBlogPost(@PathVariable(name = "id") Integer blogId) {
        return ResponseEntity.ok(blogPostService.deleteBlogPost(blogId));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPostResponseDto> updateBlogPost(@PathVariable(name = "id") @Validated Integer blogId, @RequestBody BlogPostRequestDto blogPostRequestDto) {
        return ResponseEntity.ok(blogPostService.updateBlogPost(blogId, blogPostRequestDto));

    }

}
