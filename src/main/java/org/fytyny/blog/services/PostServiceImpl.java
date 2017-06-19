package org.fytyny.blog.services;

import org.fytyny.blog.forms.dto.PostDto;
import org.fytyny.blog.model.Post;
import org.fytyny.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Override
    public Post createPost(PostDto insertionDto) {
        Post post = new Post();
        post.setAuthor(insertionDto.getAuthor());
        post.setTitle(insertionDto.getTitle());
        post.setText(insertionDto.getText());
        return  postRepository.save(post);
    }

}
