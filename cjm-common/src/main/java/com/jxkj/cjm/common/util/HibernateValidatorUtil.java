package com.jxkj.cjm.common.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @Auther: cjm
 * @Date: 2018/7/22 16:02
 * @Description:
 * @ClassName: HibernateValidatorUtil
 */
public class HibernateValidatorUtil<T> {

    public  String valida(T t,Class<?>... groups){
        //验证请求参数
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, groups);
        if(constraintViolations.iterator().hasNext() && constraintViolations.iterator().next().getMessage() != null){
            return constraintViolations.iterator().next().getMessage();
        }

        return "";
    }
}
