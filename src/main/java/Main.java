import PackageForHib.domain.userType.GermanCode;
import PackageForHib.domain.userType.MonetaryAmount;
import PackageForHib.domain.userType.SwissCode;
import PackageForHib.domain.userType.ZipCode;
import org.hibernate.type.StandardBasicTypes;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serializable;
import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //        System.out.println(StandardBasicTypes.BIG_DECIMAL.sqlType())
//        MonetaryAmount monetaryAmount = new MonetaryAmount(10, Currency.getInstance("USD"));
//        Serializable serializable = monetaryAmount.toString();
//        System.out.println(serializable);
//        serializable = monetaryAmount;
//        System.out.println(serializable);
//        Currency currency = Currency.getInstance("USD");
//        System.out.println(currency.getDisplayName());
//        ZipCode zipCode = new GermanCode("21322");
//        methodGetSomething(zipCode);
//        System.out.println(new Date());
//        Перевірка чи можна отримати параметри аннотації
//        Class<?> cl = ForAnnotation.class;
//        checkAnnotation annotation = cl.getAnnotation(checkAnnotation.class);
//        annotation.index();
//        System.out.println("Hello world!");
//        Class<?> cla = ManagerForEntitty.class;
//        Method[] m = cla.getDeclaredMethods();
//
//        System.out.println(Arrays.toString(m));
    }

    public static int methodGetSomething(ZipCode zipCode){
        if(zipCode instanceof SwissCode){
            System.out.println("YesS");
        }
        return 1;
    }
}

@checkAnnotation
class ForAnnotation{

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface checkAnnotation{
    int index() default 21;
}