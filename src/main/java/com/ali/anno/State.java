package com.ali.anno;

import com.ali.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

//元注解
@Documented
//元注解：用在类上、方法上、属性上、枚举上、包上、参数上、字段上、类型使用上
//这里只保留属性上
@Target({ElementType.FIELD})
//元注解：注解保留到哪个阶段
@Retention(RetentionPolicy.RUNTIME)

@Constraint(
        validatedBy = {StateValidation.class}   //指定提供校验规则的类
)
public @interface State {
    //提供校验失败后的提示信息
    String message() default "{state参数的值只能是已发布或者草稿}";
    //指定分组
    Class<?>[] groups() default {};
    //负载    获取到state注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
