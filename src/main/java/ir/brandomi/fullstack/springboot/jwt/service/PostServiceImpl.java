package ir.brandomi.fullstack.springboot.jwt.service;

import ir.brandomi.fullstack.springboot.jwt.entity.PostEntity;
import ir.brandomi.fullstack.springboot.jwt.model.Post;
import ir.brandomi.fullstack.springboot.jwt.repository.PostEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    private final Path path = Paths.get("uploads");
    @Autowired
    private PostEntityRepository postEntityRepository;

    @Override
    public Post addPost(Post post) throws Exception {
        try {
            PostEntity postEntity = new PostEntity();
            BeanUtils.copyProperties(post,postEntity);
           // postEntity.setUserId(post.getUserId());
            postEntity.setTimeStamp(new Date().toString());

            if (post.getImage() != null && !post.getImage().equalsIgnoreCase("null")){
               // Files.write(path.resolve("1.jpg"), post.getImage().getBytes());
                postEntity.setImage(path.toString());

                byte[] decodedImage = Base64.decodeBase64(post.getImage());
                FileOutputStream fos = new FileOutputStream(String.valueOf(path.resolve("image.jpg")));
                fos.write(decodedImage);
                fos.close();

            }else postEntity.setImage(null);
            log.info(postEntity.toString());
            postEntity = postEntityRepository.save(postEntity);

            post.setId(postEntity.getId());
            post.setImage(postEntity.getImage());

        }catch (Exception e){
            throw new Exception("Could not save post");
        }
        return post;
    }

    @Override
    public List<Post> getPost() {
        List<PostEntity> postEntities = postEntityRepository.findAll();
        List<Post> posts = new ArrayList<>();
        posts = postEntities.stream().map((postEntity) ->
               Post.builder()
                .id(postEntity.getId())
                .image(postEntity.getImage())
                .post(postEntity.getPost())
                .build())
                .collect(Collectors.toList());
        return posts;
    }
}
