package com.blogpost.dtos.records;

import java.util.Date;

public record BlogPostRequestDto(String title, String content, String author, Date publicationDate) {
}
