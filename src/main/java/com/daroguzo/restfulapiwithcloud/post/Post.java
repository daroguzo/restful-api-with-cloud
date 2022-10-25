package com.daroguzo.restfulapiwithcloud.post;

import com.daroguzo.restfulapiwithcloud.user.User;
import io.swagger.annotations.ApiModel;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "게시물 도메인 객체")
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
