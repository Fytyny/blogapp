package org.fytyny.blog.repository;

import org.fytyny.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Post, Long> {
}
