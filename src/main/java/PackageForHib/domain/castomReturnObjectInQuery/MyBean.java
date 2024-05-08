package PackageForHib.domain.castomReturnObjectInQuery;

import java.math.BigInteger;

public class MyBean {

    private Long idMessage;

    private String textMessage;

    public MyBean(Long id, String text){
        idMessage = id;
        textMessage = text;
    }

    public MyBean(){

    }

    public long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(long idMessage) {
        this.idMessage = idMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "idMessage=" + idMessage +
                ", textMessage='" + textMessage + '\'' +
                '}';
    }
}
