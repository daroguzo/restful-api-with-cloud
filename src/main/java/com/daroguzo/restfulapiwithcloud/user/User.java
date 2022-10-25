package com.daroguzo.restfulapiwithcloud.user;


import com.daroguzo.restfulapiwithcloud.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @ApiModelProperty(notes ="사용자 이름을 입력해 주세요")
    private String name;

    @Column
    @ApiModelProperty(notes ="사용자 비밀번호를 입력해 주세요")
    private String password;

    @Column
    @ApiModelProperty(notes ="사용자 주민번호를 입력해 주세요")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime revised;

}
