package com.daroguzo.restfulapiwithcloud.user;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@Builder
public class UserDto {

    @Size(min = 3, max = 15, message = "이름은 2~15자리의 문자열이어야 합니다.")
    private String name;

    @Past
    private LocalDateTime revised;
}
