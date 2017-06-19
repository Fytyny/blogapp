package org.fytyny.blog.repository;

import org.fytyny.blog.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public Page<Comment> findAllByPostOrderByTimestampDesc(Pageable pageable);
}
