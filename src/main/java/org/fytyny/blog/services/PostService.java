package org.fytyny.blog.services;

import org.fytyny.blog.forms.dto.PostDto;
import org.fytyny.blog.model.Post;

public interface PostService {
    public Post createPost(PostDto insertionDto);
}
