package PackageForHib.domain;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Access(AccessType.FIELD) // визначає по чому виконується доступ - поля чи методи дотупу (get;set)
@Entity
public class Login {

    @Id
    int id;

//    @Column(nullable = false)
//    @Basic(optional = false) // 21,22 це аналог @NotNull також створюють обмеження обнуленя для стовпця
    @NotNull
    @Size( min = 4, max = 24, message = "Size password is incorrect")
    protected String password;
    @Future
    protected Date loginDate;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
