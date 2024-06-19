/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uas_last_pbo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author ADVAN
 */

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="user_id")
public class Student extends User{
   
    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
        this.studentNameId = username;
    }
    
    @Column(name="student_id", nullable=false, unique=true)
    private String studentId;
    
    @Column(name="student_name", nullable=false)
    private String studentNameId;
    
    @ManyToMany
    @JoinTable(
        name = "student_class",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private Set<Class> classes = new HashSet<>();
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // One-to-Many relationship with Score entity
    private Set<Score> scores = new HashSet<>();
    
    @ManyToOne(fetch = FetchType.LAZY) // Many-to-One relationship with Teacher
    @JoinColumn(name = "dosenPA") // Foreign key column for Teacher
    private Teacher supervisor;
    

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }
    
    public String getUsernameId() {
        return studentNameId;
    }
    
    public Teacher getSupervisor() {
        return supervisor;
    }
    
    public Set<Score> getScores() {
        return scores;
    }
    
    public Set<Class> getClasses() {
        return classes;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setUsernameId(String studentNameId) {
        this.studentNameId = studentNameId;
    }
    
    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }
    
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
    
    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
    
    public void addClass(Class clazz) {
        this.classes.add(clazz);
        clazz.getStudents().add(this);
    }
    
    // Menambahkan metode untuk mencetak nilai mahasiswa
    public void printAllScores() {
        if (scores.isEmpty()) {
            System.out.println("No scores available.");
        } else {
            for (Score score : scores) {
                System.out.printf("| %s | %s | %d |\n",
                    score.getCourse().getCourseId(),
                    score.getCourse().getName(),
                    score.getScore());
            }
        }
    }

    // Menghitung IPK dengan dua angka di belakang koma menggunakan rumus yang diberikan
    public String calculateGPA() {
        if (scores.isEmpty()) {
            return "0.00";
        }

        int totalScore = 0;
        int totalCredits = 0;

        for (Score score : scores) {
            Course course = score.getCourse();
            int credits = course.getCourseSks();

            totalCredits += credits;
            totalScore += score.getScore() * credits;
        }

        // Menghitung rata-rata nilai yang ditimbang dengan credits
        float weightedAverage = (float) totalScore / totalCredits;

        // Mengubah rata-rata nilai dari skala 0-100 menjadi skala 0-4
        float gpa = (weightedAverage / 100) * 4;

        // Memformat GPA dengan dua angka di belakang koma
        return String.format("%.2f", gpa);
    }
    
    
}
