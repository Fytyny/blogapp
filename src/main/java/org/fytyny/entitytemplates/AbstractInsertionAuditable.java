package org.fytyny.entitytemplates;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * // Creating implementation of AuditorAware and override its methods to provide currently logged in user
 class AuditorAwareImpl implements AuditorAware<String> {

@Override
public String getCurrentAuditor() {
return "Naresh";
// Can use Spring Security to return currently logged in user
// return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
}
}
 * @param <U>
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractInsertionAuditable<U> extends AbstractEntity{
    @Column(nullable = false)
    protected String text;

    @CreatedBy
    @ManyToOne(cascade = CascadeType.ALL)
    protected U author;

    @ManyToOne
    @LastModifiedBy
    protected U lastModifiedBy;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(nullable = false)
    protected Date created;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date updated;

    @Column(columnDefinition = "0")
    protected Integer voteValue = 0;

    public Integer getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Integer voteValue) {
        this.voteValue = voteValue;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public U getAuthor() {
        return author;
    }

    public void setAuthor(U author) {
        this.author = author;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
