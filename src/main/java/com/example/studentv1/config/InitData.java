package com.example.studentv1.config;

import com.example.studentv1.model.Student;
import com.example.studentv1.model.Teacher;
import com.example.studentv1.repositories.StudentRepository;
import com.example.studentv1.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Viggo");
        s1.setBornDate(LocalDate.now());
        s1.setBornTime(LocalTime.now());

        studentRepository.save(s1);
        System.out.println("saved");

        List<Student> lst = studentRepository.findAll();
        System.out.println("Antal studerende i database=" + lst.size());

        Teacher t1 = new Teacher();
        t1.setId(1);
        t1.setName("Anne-sofie");
        t1.setBornDate(LocalDate.now());
        t1.setBornTime(LocalTime.now());
        t1.setFunFact("I love snasketime");
        t1.setLevel("4/10");


        teacherRepository.save(t1);
        System.out.println("t1 is saved");

        List<Teacher> lst1 = teacherRepository.findAll();
        System.out.println("Antal milfs i dit lokale område=" + lst1.size());

    }
}
