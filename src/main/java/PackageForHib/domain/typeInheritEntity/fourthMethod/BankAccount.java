package PackageForHib.domain.typeInheritEntity.fourthMethod;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount extends BillingDetails{

    @NotNull
    protected String account;
    @NotNull
    protected String bankname;
    @NotNull
    protected String swift;

    public BankAccount(String account, String bankname, String swift) {
        this.account = account;
        this.bankname = bankname;
        this.swift = swift;
    }

    public BankAccount() {

    }
}
