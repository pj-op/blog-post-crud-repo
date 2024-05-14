package com.blogpost.BlogPostPOC;

import com.blogpost.controller.BlogPostController;
import com.blogpost.dtos.records.BlogPostRequestDto;
import com.blogpost.dtos.records.BlogPostResponseDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class BlogPostPocApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        BlogPostController mockBlockPostController = Mockito.mock(BlogPostController.class);
        BlogPostRequestDto blogPostRequestDto = Mockito.mock(BlogPostRequestDto.class);
        when(mockBlockPostController.createBlogPost(blogPostRequestDto)).thenReturn(ResponseEntity.ok(new BlogPostResponseDto(1, "", "", "", new Date())));

        mockMvc.perform(MockMvcRequestBuilders.post("/blogpost/")
                .content("""
                        {
                            "title": "testqq",
                            "content": "aysgdyasgd",
                            "author": "abc",
                            "publicationDate": "2012-12-10"
                        }""")
                .accept(MediaType.APPLICATION_JSON_VALUE)
        );

    }

}
