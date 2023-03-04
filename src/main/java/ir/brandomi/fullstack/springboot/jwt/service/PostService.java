package ir.brandomi.fullstack.springboot.jwt.service;

import ir.brandomi.fullstack.springboot.jwt.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
