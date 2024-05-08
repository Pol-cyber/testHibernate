package PackageForHib.domain;



import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckValidation {

    @Test
    public void testValidation(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();


        Login login = new Login();
        login.setLoginDate(new Date());

        Set<ConstraintViolation<Login>> set = validator.validate(login);
        assertEquals (2,set.size());

        String myConstraint = set.iterator().next().getMessage();
        System.out.println(myConstraint);
    }
}
