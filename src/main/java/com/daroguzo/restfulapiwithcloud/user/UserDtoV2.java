package com.daroguzo.restfulapiwithcloud.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@JsonFilter("UserInfo")
public class UserDtoV2 extends User{

    private String grade;
}
