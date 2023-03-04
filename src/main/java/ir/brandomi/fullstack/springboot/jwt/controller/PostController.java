package ir.brandomi.fullstack.springboot.jwt.controller;

import ir.brandomi.fullstack.springboot.jwt.model.Post;
import ir.brandomi.fullstack.springboot.jwt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post addPost(@RequestParam Map<String,String> requestParams) throws Exception {
        String strPost = requestParams.get("post");
        String strUserId = requestParams.get("userId");
        String strImage = requestParams.get("image");
        String strImageName = requestParams.get("imageName");

        Post post = Post.builder()
                .image(strImage)
                .imageName(strImageName)
                .userId(Integer.parseInt(strUserId))
                .post(strPost)
                .build();
        post = postService.addPost(post);
        return post;
    }

    public List<Post> getPost(){
        return postService.getPost();
    }

}
