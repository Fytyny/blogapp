package org.fytyny.blog.model;

import org.fytyny.entitytemplates.AbstractInsertion;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment extends AbstractInsertion {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "replyFor")
    private List<Comment> replies;


    @ManyToOne(cascade = CascadeType.ALL)
    private Comment replyFor;

    public Comment getReplyFor() {
        return replyFor;
    }

    public void setReplyFor(Comment replyFor) {
        this.replyFor = replyFor;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
}