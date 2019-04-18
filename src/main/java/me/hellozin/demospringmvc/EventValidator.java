package me.hellozin.demospringmvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Event event = (Event) o;
        if (event.getId() == 0) {
            errors.rejectValue("id", "ManagerAccess", "Can not access with id 0.");
        }
    }
}
