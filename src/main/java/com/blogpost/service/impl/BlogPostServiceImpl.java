package com.blogpost.service.impl;

import com.blogpost.dtos.records.BlogPostRequestDto;
import com.blogpost.dtos.records.BlogPostResponseDto;
import com.blogpost.entities.BlogPost;
import com.blogpost.exceptions.BlogPostNotExistException;
import com.blogpost.repository.BlogPostRepository;
import com.blogpost.service.BlogPostService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("blogPostService")
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPostResponseDto createBlogPost(BlogPostRequestDto blogPostRequestDto) {
        BlogPost blogPost = blogPostRepository.save(convertBlogPostDtoToBlogPost(blogPostRequestDto));
        return convertBlogPostEntityToBlogPostResponseDto(Optional.of(blogPost));
    }

    public BlogPostResponseDto updateBlogPost(Integer blogPostId, BlogPostRequestDto blogPostRequestDto) {
        Optional<BlogPost> blogPostOptional = blogPostRepository.findById(blogPostId);

        BlogPost blogPost = blogPostOptional.orElseThrow(() -> new BlogPostNotExistException("Id doesn't exist"));

        blogPost.setAuthor(blogPostRequestDto.author());
        blogPost.setTitle(blogPostRequestDto.title());
        blogPost.setContent(blogPostRequestDto.content());
        blogPost.setPublicationDate(blogPostRequestDto.publicationDate());

        blogPostRepository.updateBlogPostById(blogPost.getAuthor(), blogPost.getTitle(), blogPost.getContent(), blogPost.getPublicationDate(), blogPostId);

        return convertBlogPostEntityToBlogPostResponseDto(Optional.of(blogPost));
    }

    public String deleteBlogPost(Integer blogPostId) {
        try {
            blogPostRepository.deleteById(blogPostId);
        } catch (Exception e) {
            throw new BlogPostNotExistException("Not exist");
        }
        return "deleted";
    }

    public BlogPostResponseDto getBlogPost(Integer blogPostId) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(blogPostId);
        return convertBlogPostEntityToBlogPostResponseDto(blogPost);
    }

    private BlogPost convertBlogPostDtoToBlogPost(BlogPostRequestDto blogPostRequestDto) {
        BlogPost blogPost = new BlogPost();
        blogPost.setAuthor(blogPostRequestDto.author());
        blogPost.setTitle(blogPostRequestDto.title());
        blogPost.setContent(blogPostRequestDto.content());
        blogPost.setPublicationDate(blogPostRequestDto.publicationDate());

        return blogPost;
    }

    private BlogPostResponseDto convertBlogPostEntityToBlogPostResponseDto(Optional<BlogPost> blogPost) {
        BlogPost blogPostEntity = blogPost.orElseThrow(() -> new IllegalArgumentException("Please provide valid argument"));
        return new BlogPostResponseDto(blogPostEntity.getId(), blogPostEntity.getTitle(), blogPostEntity.getContent(), blogPostEntity.getAuthor(), blogPostEntity.getPublicationDate());
    }
}
