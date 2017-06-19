package org.fytyny.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.fytyny.account.model.User;
import org.fytyny.entitytemplates.AbstractInsertionAuditable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment extends AbstractInsertionAuditable<User> {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "replyFor")
    private List<Comment> replies;

    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Comment replyFor;

    public Comment(){}
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
