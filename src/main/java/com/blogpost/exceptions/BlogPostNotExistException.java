package com.blogpost.exceptions;

public class BlogPostNotExistException extends RuntimeException {
    public BlogPostNotExistException(String message) {
        super(message);
    }
}
