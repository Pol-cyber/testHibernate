package PackageForHib.OvverideHibClass;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class NameStrategy extends org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl{


    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier("Pat_"+name.getText(),name.isQuoted());
    }
}
