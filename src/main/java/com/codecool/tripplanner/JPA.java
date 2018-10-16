package com.codecool.tripplanner;

import com.codecool.tripplanner.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JPA {

    public static void populateDb(EntityManager em) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate1 = Calendar.getInstance().getTime();
//        Date birthDate2 = Calendar.getInstance().getTime();
//        try {
//            birthDate1 = sdf.parse("1997-07-21");
//            birthDate2 = sdf.parse("1993-12-01");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        List<String> phoneNumbers = new ArrayList<>(Arrays.asList("2d2","dsd"));
//        Klass classBp2 = new Klass("Budapest 2016-2", CCLocation.BUDAPEST);
//        Address address = new Address("Hungary", "1234", "Budapest", "Macskakő út 5.");
//        Student student = new Student("Ödön", "odon@tokodon.hu", birthDate1, address, phoneNumbers);
//        classBp2.addStudent(student);
//
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        em.persist(address);
//        em.persist(student);
//        transaction.commit();
//        System.out.println("\n### Ödön saved.\n");
//
//        Address address2 = new Address("Hungary", "6789", "Budapest", "Harap u. 3.");
//        Student student2 = new Student("Aladár", "ktyfl@gmail.com", birthDate2, address2, phoneNumbers);
//        classBp2.addStudent(student2);
//
//        transaction.begin();
//        em.persist(student2);
//        em.persist(address2);
//        em.persist(classBp2);
//        transaction.commit();
//        System.out.println("\n### Aladár saved.\n");
//        em.remove(classBp2); // THis is to remove the class from the DB
    }


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
        EntityManager em = emf.createEntityManager();

        populateDb(em);
        em.clear(); //clear hibernate cache - force next statements to read data from db



        List<String> result = em.createNamedQuery("Student.findStudentsStartingWithChar").getResultList();
        for (String name: result) {
            System.out.println(name);
        }


        em.close();
        emf.close();
    }
}
