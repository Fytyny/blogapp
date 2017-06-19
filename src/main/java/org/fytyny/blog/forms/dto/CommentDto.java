package org.fytyny.blog.forms.dto;

import org.fytyny.account.model.User;
import org.fytyny.blog.forms.validators.LengthValidator;

public class CommentDto {
    @LengthValidator
    private String text;

    private User author;

    private User modifiedBy;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
