package org.fytyny.blog.controller;

import org.fytyny.blog.forms.dto.PostDto;
import org.fytyny.blog.model.Comment;
import org.fytyny.blog.model.Post;
import org.fytyny.blog.repository.CommentRepository;
import org.fytyny.blog.repository.PostRepository;
import org.fytyny.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public String showPost(WebRequest webRequest, Model model, @PathVariable("id") Post post, @RequestParam Integer commentPage, Pageable pageable){
        model.addAttribute("post", post);
        Page<Comment> comments = commentRepository.findAllByPostOrderByTimestampDesc(pageable);
        model.addAttribute("comments", comments);
        return "showPost";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("post") @Valid PostDto postDto,
             BindingResult result, WebRequest request, Errors errors) {
        Post created = null;
        if (!result.hasErrors()) {
             created = postService.createPost(postDto);
             return new ModelAndView("successPostCreation", "post", postDto);
        }
        return new ModelAndView("postCreator", "post", postDto);
    }
}
