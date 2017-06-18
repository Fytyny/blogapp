package org.fytyny.blog.model;

import org.fytyny.entitytemplates.AbstractInsertion;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Post extends AbstractInsertion {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    public Post() {
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
