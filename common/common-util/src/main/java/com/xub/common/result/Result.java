package com.xub.common.result;

import lombok.Data;

/**
 * 1.如果一个类被 <T>的形式定义，那么它就被称为是泛型类。
 * 2.此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 *   T 代表一般的任何类。
 *   E 代表 Element 的意思
 *   K 代表 Key 的意思。
 *   V 代表 Value 的意思，通常与 K 一起配合使用。
 *   S 代表 Subtype 的意思，文章后面部分会讲解示意。
 * 3.泛型类还可以这样接受多个类型参数Generic<T,E,v>
 */

@Data
public class Result<T> {

    private Integer code; //状态码
    private String message; //返回信息
    private T data; //数据

    //私有化构造方法
    private Result(){}

    //封装返回的数据
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum){
        Result<T> result = new Result<>();
        //数据
        if (body != null){
            result.setData(body);
        }
        //状态码
        result.setCode(resultCodeEnum.getCode());
        //返回信息
        result.setMessage(resultCodeEnum.getMessage());

        return result;
    }


    //请求成功，无数据返回
    public static<T> Result<T> ok(){
        return build(null, ResultCodeEnum.SUCCESS);
    }
    //请求成功，有数据返回
    public static<T> Result<T> ok(T data){
        return build(data,ResultCodeEnum.SUCCESS);
    }

    //请求失败，无数据返回
    public static<T> Result<T> fail() {
        return build(null,ResultCodeEnum.FAIL);
    }

    //请求失败，有数据返回
    public static<T> Result<T> fail(T data) {
        return build(data,ResultCodeEnum.FAIL);
    }

}
