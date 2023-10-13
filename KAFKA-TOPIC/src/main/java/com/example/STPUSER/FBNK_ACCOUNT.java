package com.example.STPUSER;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STPUSER.FBNK_ACCOUNT")
public class FBNK_ACCOUNT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RECID;
    @Column(name="XMLRECORD")
    private  String XMLRECORD;




    public String getXMLRECORD() {
        return XMLRECORD;
    }


    public long getRECID() {
        return RECID;
    }
}
