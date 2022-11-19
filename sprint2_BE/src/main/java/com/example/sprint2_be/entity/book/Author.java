package com.example.sprint2_be.entity.book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    private String authorName;

    private String authorAvatar;

    public Author() {
    }

    public Author(String authorName, String authorAvatar) {
        this.authorName = authorName;
        this.authorAvatar = authorAvatar;
    }

    public Author(Long authorId, String authorName, String authorAvatar) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorAvatar = authorAvatar;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }
}
