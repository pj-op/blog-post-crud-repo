package com.blogpost.service;


import com.blogpost.dtos.records.BlogPostRequestDto;
import com.blogpost.dtos.records.BlogPostResponseDto;

public interface BlogPostService {
    BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto);

    BlogPostResponseDto updateBlogPost(Integer blogPostId, BlogPostRequestDto blogPostRequestDto);

    String deleteBlogPost(Integer blogPostId);

    BlogPostResponseDto getBlogPost(Integer blogPostId);

}
