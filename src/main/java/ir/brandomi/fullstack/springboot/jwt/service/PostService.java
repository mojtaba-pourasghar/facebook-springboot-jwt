package ir.brandomi.fullstack.springboot.jwt.service;

import ir.brandomi.fullstack.springboot.jwt.model.Post;

public interface PostService {
    Post addPost(Post post) throws Exception;
}
