package PackageForHib.domain.EntityListenersPriemniki.byUsingHibernate.journalAudit;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;


// для того щоб не переоприділяти всі методи Interceptor можна використати EmptyInterceptor
public class ClassForInterceptor extends EmptyInterceptor {


    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("Сутність - "+ entity);
        return false; // стан не змінюється
    }
}
