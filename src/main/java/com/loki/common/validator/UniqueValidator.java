package com.loki.common.validator;

import com.loki.common.annotation.Unique;
import com.loki.common.service.FieldValueExist;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author palmurugan
 */
@Component
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    private static final String ID = "id";

    @Autowired
    private ApplicationContext applicationContext;

    private FieldValueExist fieldValueExistService;

    private String fieldName;

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Object idValue = new BeanWrapperImpl(object).getPropertyValue(ID);
        Object value = new BeanWrapperImpl(object).getPropertyValue(this.fieldName);
        Long id = idValue != null ? Long.parseLong(idValue.toString()) : null;
        boolean result = this.fieldValueExistService == null ? Boolean.TRUE : Boolean.FALSE;
        return (!result) ? !this.fieldValueExistService.fieldValueExists((id), value, this.fieldName) : Boolean.TRUE;
    }

    @Override
    public void initialize(Unique unique) {
        Class<? extends FieldValueExist> clazz = unique.service();
        String serviceQualifier = unique.serviceQualifier();
        this.fieldName = unique.fieldName();
        if (applicationContext != null) {
            this.fieldValueExistService = (serviceQualifier.isEmpty() ? applicationContext.getBean(clazz)
                    : applicationContext.getBean(serviceQualifier, clazz));
        }
    }
}
