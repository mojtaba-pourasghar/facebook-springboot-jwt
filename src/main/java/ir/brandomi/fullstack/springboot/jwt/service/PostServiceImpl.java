package ir.brandomi.fullstack.springboot.jwt.service;

import ir.brandomi.fullstack.springboot.jwt.entity.PostEntity;
import ir.brandomi.fullstack.springboot.jwt.model.Post;
import ir.brandomi.fullstack.springboot.jwt.repository.PostEntityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostEntityRepository postEntityRepository;

    @Override
    public Post addPost(Post post) throws Exception {
        try {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post,postEntity);
            postEntity.setTimeStamp(new Date().toString());

            if (post.getImage() != null && !post.getImage().equalsIgnoreCase("null")){
                postEntity.setImage(post.getImage());
            }else postEntity.setImage(null);
            postEntity = postEntityRepository.save(postEntity);

            post.setId( Integer.toString(postEntity.getId()));
            post.setImage(postEntity.getImage());

        }catch (Exception e){
            throw new Exception("Could not save post");
        }
        return post;
    }
}
