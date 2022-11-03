package com.cieep;

import com.cieep.modelos.Alumno;
import com.cieep.modelos.Curso;
import com.cieep.modelos.Equipo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Jerónimo Francisco", "Pastrana Royo", "53890901S");
        Curso curso = new Curso("DAM", "to majos", 'C');
        Equipo equipo = new Equipo("Apple", "iMac 21");
        alumno.setEquipo(equipo);
        alumno.setCurso(curso);

        curso.getAlumnos().add(alumno);
        equipo.setAlumno(alumno);

        //CREA LA VARIABLE QUE PUEDE CONECTAR
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //VARIABLE DE LA CONEXIÓN
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //CREATE
        //session.persist(alumno);
        session.persist(curso);
        session.persist(equipo);


        //READ
//        Alumno a = session.get(Alumno.class, 1);
//        System.out.println(a.toString());
//
//        //UPDATE
//        /*a.setNombre("Jero");
//        session.merge(a);*/
//
//        //DELETE
//        session.remove(a);

        session.getTransaction().commit();
        session.close();
    }
}