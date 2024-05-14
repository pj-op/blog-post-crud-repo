package com.blogpost.exceptionhandlers;

import com.blogpost.exceptions.BlogPostNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException() {
        return ResponseEntity.ok("No such element present here");
    }

    @ExceptionHandler(value = BlogPostNotExistException.class)
    public ResponseEntity<String> handleBlogPostNotExistException() {
        return ResponseEntity.ok("BlogPostNotExistException");
    }
}
