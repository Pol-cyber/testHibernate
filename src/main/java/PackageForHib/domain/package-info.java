@org.hibernate.annotations.NamedQueries(
        @org.hibernate.annotations.NamedQuery(
                name = "myNewQueryy",
                query = "SELECT m FROM Message m"
        )
)
package PackageForHib.domain;

import PackageForHib.domain.userType.hibernateAdapterUserType.MonetaryAmountUserType;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;