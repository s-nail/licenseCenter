package com.hundsun.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Created by jiayq24996 on 2019-06-13
 */
@Getter
@Setter
public class User {
    @NotBlank(message = "用户名不能为空")
    private String name;
    @NotBlank(message="年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String age;
}
