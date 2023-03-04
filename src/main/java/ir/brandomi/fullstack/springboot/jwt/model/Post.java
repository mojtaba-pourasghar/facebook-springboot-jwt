package ir.brandomi.fullstack.springboot.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private int userId;
    private String post;
    private String image;
    private String imageName;
}
