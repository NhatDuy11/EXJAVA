package com.example.STPUSER;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.*;
public class main {
    public static void main(String[] args) {
        // Create session factory object
        // Create session factory object
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // getting session object from session factory
        Session session = sessionFactory.openSession();
        // getting transaction object from session object
        session.beginTransaction();
        String sql = "SELECT * FROM STPUSER.FBNK_ACCOUNT";


        SQLQuery query = session.createSQLQuery(sql);// Native SQL Query
        query.addEntity(FBNK_ACCOUNT.class);
        List<FBNK_ACCOUNT> FBNK_ACCOUNTSS = query.list();

        for (FBNK_ACCOUNT fBNK_ACCOUNT : FBNK_ACCOUNTSS) {
            System.out.println("FBNK_ACCOUNT:"+fBNK_ACCOUNT.getXMLRECORD());
            System.out.println("FBNK_ACCOUNT:"+fBNK_ACCOUNT.getRECID());
        }

        session.getTransaction().commit();
        session.close();
    }
    }

