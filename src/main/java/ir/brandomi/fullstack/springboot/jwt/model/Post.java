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
    private String id;
    private String userId;
    private String post;
    private String image;
}
