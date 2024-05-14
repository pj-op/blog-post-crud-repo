package com.blogpost.dtos.records;

import java.util.Date;

public record BlogPostResponseDto(Integer id, String title, String content, String author, Date publicationDate) {
}
