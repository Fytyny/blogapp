package org.fytyny.entitytemplates;

import org.fytyny.account.model.User;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbstractInsertion extends AbstractEntity{
    @Column(nullable = false)
    private String text;
    @ManyToOne(cascade = CascadeType.ALL)
    private User author;
    @Column(nullable = false)
    private Timestamp timestamp;

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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
