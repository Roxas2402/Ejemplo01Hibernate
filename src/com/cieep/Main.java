package com.cieep;

import com.cieep.modelos.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Jerónimo Francisco", "Pastrana Royo", "53890901S");



        //CREA LA VARIABLE QUE PUEDE CONECTAR
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //VARIABLE DE LA CONEXIÓN
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(alumno);

        session.getTransaction().commit();
        session.close();
    }
}