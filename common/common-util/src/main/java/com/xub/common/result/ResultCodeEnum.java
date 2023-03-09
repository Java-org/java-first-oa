package com.xub.common.result;

import lombok.Getter;

/**
 * 将@MapperScan("com.xub.auth.mapper")提取到该配置类上面，统一管理，启动类就不需要
 */
@Getter
public enum ResultCodeEnum {
    //枚举的选项
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    LOGIN_ERROR(208,"认证失败"),
    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限");

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
