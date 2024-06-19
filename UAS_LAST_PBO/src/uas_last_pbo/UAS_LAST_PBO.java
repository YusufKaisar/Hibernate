/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uas_last_pbo;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADVAN
 */
public class UAS_LAST_PBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction = session.beginTransaction();
        
        User user = new User("ninja", "12345");
        session.save(user);
        
        //Dosen
        Teacher teacher1 = new Teacher("Pak Jos", "12345", "2000");
        session.save(teacher1);
        Teacher teacher2 = new Teacher("Buk Dian", "12345", "2001");
        session.save(teacher2);
        Teacher teacher3 = new Teacher("Buk Amel", "12345", "2002");
        session.save(teacher3);
        Teacher teacher4 = new Teacher("Buk Anandhini", "12345", "2003");
        session.save(teacher4);

        //Mahasiswa
        Student student1 = new Student("Yusuf", "12345", "221401001");
        student1.setSupervisor(teacher1);
        session.save(student1);

        Student student2 = new Student("Kaisar", "12345", "221401002");
        student2.setSupervisor(teacher1);
        session.save(student2);

        Student student3 = new Student("Salamun", "12345", "221401003");
        student3.setSupervisor(teacher2);
        session.save(student3);
        
        Student student4 = new Student("Santana", "12345", "221401004");
        student4.setSupervisor(teacher2);
        session.save(student4);
        
        Student student5 = new Student("Ahmad", "12345", "221401005");
        student5.setSupervisor(teacher3);
        session.save(student5);
        
        Student student6 = new Student("Dadang", "12345", "221401006");
        student6.setSupervisor(teacher3);
        session.save(student6);
        
        Student student7 = new Student("Tono", "12345", "221401007");
        student7.setSupervisor(teacher4);
        session.save(student7);
        
        Student student8 = new Student("Asep", "12345", "221401008");
        student8.setSupervisor(teacher4);
        session.save(student8);
        
        Student student9 = new Student("Budi", "12345", "221401009");
        student9.setSupervisor(teacher1);
        session.save(student9);
        
        Student student10 = new Student("Cecep", "12345", "221401010");
        student10.setSupervisor(teacher1);
        session.save(student10);
        
        Student student11 = new Student("Eka", "12345", "221401011");
        student11.setSupervisor(teacher2);
        session.save(student11);

        Student student12 = new Student("Dewi", "12345", "221401012");
        student12.setSupervisor(teacher3);
        session.save(student12);

        Student student13 = new Student("Rama", "12345", "221401013");
        student13.setSupervisor(teacher4);
        session.save(student13);

        Student student14 = new Student("Shinta", "12345", "221401014");
        student14.setSupervisor(teacher2);
        session.save(student14);

        Student student15 = new Student("Bagas", "12345", "221401015");
        student15.setSupervisor(teacher3);
        session.save(student15);

        Student student16 = new Student("Bintang", "12345", "221401016");
        student16.setSupervisor(teacher4);
        session.save(student16);

        Student student17 = new Student("Ari", "12345", "221401017");
        student17.setSupervisor(teacher2);
        session.save(student17);

        Student student18 = new Student("Vina", "12345", "221401018");
        student18.setSupervisor(teacher3);
        session.save(student18);

        Student student19 = new Student("Farhan", "12345", "221401019");
        student19.setSupervisor(teacher4);
        session.save(student19);

        Student student20 = new Student("Lia", "12345", "221401020");
        student20.setSupervisor(teacher2);
        session.save(student20);

        //Matkul
        Course course1 = new Course("Game Development", "IK010101");
        session.save(course1);
        
        Course course2 = new Course("Dasar Pemrograman", "IK020202");
        session.save(course2);
        
        Course course3 = new Course("Machine Learning", "IK030303");
        session.save(course3);
        
        Course course4 = new Course("Analisis dan Desain Perangkat Lunak", "IK040404");
        session.save(course4);
        
        //kelas
        Class class1 = new Class("KomA GameDev");
        class1.setTeacher(teacher1);
        class1.setCourse(course1);
        class1.getStudents().add(student1);
        class1.getStudents().add(student2);
        class1.getStudents().add(student3);
        class1.getStudents().add(student4);
        class1.getStudents().add(student5);
        class1.getStudents().add(student6);
        class1.getStudents().add(student7);
        session.save(class1);
        
        Class class2 = new Class("KomA Daspro");
        class2.setTeacher(teacher2);
        class2.setCourse(course2);
        class2.getStudents().add(student6);
        class2.getStudents().add(student7);
        class2.getStudents().add(student8);
        class2.getStudents().add(student9);
        class2.getStudents().add(student10);
        session.save(class2);
        
        Class class3 = new Class("KomA ML");
        class3.setTeacher(teacher3);
        class3.setCourse(course3);
        class3.getStudents().add(student1);
        class3.getStudents().add(student11);
        class3.getStudents().add(student12);
        class3.getStudents().add(student13);
        class3.getStudents().add(student14);
        session.save(class3);
        
        Class class4 = new Class("KomA ADPL");
        class4.setTeacher(teacher4);
        class4.setCourse(course4);
        class4.getStudents().add(student15);
        class4.getStudents().add(student16);
        class4.getStudents().add(student17);
        class4.getStudents().add(student18);
        class4.getStudents().add(student19);
        class4.getStudents().add(student20);
        session.save(class4);
        
        //nilai
        // Creating and saving Scores
        Score score1 = new Score(95, student1, course1);
        student1.getScores().add(score1);
        course1.getScores().add(score1);
        session.save(score1);

        Score score2 = new Score(85, student1, course3);
        student1.getScores().add(score2);
        course3.getScores().add(score2);
        session.save(score2);

        Score score3 = new Score(75, student2, course1);
        student2.getScores().add(score3);
        course1.getScores().add(score3);
        session.save(score3);

        Score score4 = new Score(70, student6, course2);
        student6.getScores().add(score4);
        course2.getScores().add(score4);
        session.save(score4);

        Score score5 = new Score(90, student3, course1);
        student3.getScores().add(score5);
        course1.getScores().add(score5);
        session.save(score5);    

        transaction.commit();

        System.out.println(" ");

        // Print all scores for each student
        System.out.println("KHS " + student1.getUsernameId() + ":");
        System.out.println("| Course Code |" + " Course Name |" + " Score |");
        student1.printAllScores();
        System.out.println("| IPK " + ": " + student1.calculateGPA() + " |");
        System.out.println("---------------------------------------------------");

        System.out.println("KHS " + student2.getUsernameId() + ":");
        System.out.println("| Course Code |" + " Course Name |" + " Score |");
        student2.printAllScores();
        System.out.println("| IPK " + ": " + student2.calculateGPA() + " |");
        System.out.println("---------------------------------------------------");

        System.out.println("KHS " + student3.getUsernameId() + ":");
        System.out.println("| Course Code |" + " Course Name |" + " Score |");
        student3.printAllScores();
        System.out.println("| IPK " + ": " + student3.calculateGPA() + " |");
        System.out.println("---------------------------------------------------");
        
        System.out.println("KHS " + student6.getUsernameId() + ":");
        System.out.println("| Course Code |" + " Course Name |" + " Score |");
        student6.printAllScores();
        System.out.println("| IPK " + ": " + student6.calculateGPA() + " |");
        System.out.println("---------------------------------------------------");


        session.close();
    }
    
}
