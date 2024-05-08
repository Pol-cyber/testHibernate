package PackageForHib.domain.userType.hibernateAdapterUserType;

import PackageForHib.domain.userType.MonetaryAmount;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

import javax.naming.OperationNotSupportedException;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Currency;
import java.util.Properties;


public class MonetaryAmountUserType implements DynamicParameterizedType, CompositeUserType {

    protected Currency convertTo;


    @Override
    public void setParameterValues(Properties properties) {
//        ParameterType parameterType =      // для динамічного отримання параметрів
//        (ParameterType) properties.get(PARAMETER_TYPE);
//        String[] columns = parameterType.getColumns();
//        String table = parameterType.getTable();
//        Annotation[] annotations = parameterType.getAnnotationsMethod();

           String s = properties.getProperty("convertTo");
           convertTo = Currency.getInstance(s != null ? s : "USD");
    }

    @Override
    public String[] getPropertyNames() {
        return new String[]{"value","currency"};
    }

    @Override
    public Type[] getPropertyTypes() {
        return new Type[]{StandardBasicTypes.INTEGER,StandardBasicTypes.CURRENCY};
    }

    @Override
    public Object getPropertyValue(Object o, int i) throws HibernateException {
        MonetaryAmount monetaryAmount = (MonetaryAmount) o;
        if(i == 0){
            return monetaryAmount.getValue();
        }
        return monetaryAmount.getCurrency();
    }

    @Override
    public void setPropertyValue(Object o, int i, Object o1) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class returnedClass() {
        return MonetaryAmount.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return  x == y || !(x == null || y == null) && x.equals(y);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        MonetaryAmount monetaryAmount = new MonetaryAmount(resultSet.getInt(strings[0]),Currency.getInstance(resultSet.getString(strings[1])));
        return monetaryAmount;
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
          if(o == null){
              preparedStatement.setNull(i, Types.INTEGER);
              preparedStatement.setNull(i+1,Types.VARCHAR);
              // INSERT INTO TABLE VALUES (?,?)
          } else {
              MonetaryAmount monetaryAmount = (MonetaryAmount)o;
              MonetaryAmount converMonetary = converTMonetary(monetaryAmount);
              preparedStatement.setInt(i,converMonetary.getValue());
              preparedStatement.setString(i+1,converMonetary.getCurrency().toString());
          }
    }

    private MonetaryAmount converTMonetary(MonetaryAmount monetaryAmount){
        return new MonetaryAmount(monetaryAmount.getValue()*2, monetaryAmount.getCurrency());
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;   //Если фреймворку Hibernate потребуется скопировать значение, он вызовет этот метод.
        // В случае неизменяемых классов, таких как MonetaryAmount, можно возвращать передан-
        // ное значение.
    }

    @Override
    public boolean isMutable() {
        return false;  // Если известно, что класс MonetaryAmount неизменяемый, Hibernate может применять не-
        // которые оптимизации
    }

    @Override
    public Serializable disassemble(Object o, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException {
        return (MonetaryAmount)o;
    }

    @Override
    public Object assemble(Serializable serializable, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object o, Object o1, SharedSessionContractImplementor sharedSessionContractImplementor, Object o2) throws HibernateException {
        return o;
    }


}
