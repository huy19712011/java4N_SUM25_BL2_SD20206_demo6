package org.example.demo6.service;

import org.example.demo6.entity.Student;
import org.example.demo6.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository repository = new StudentRepository();

    public List<Student> getStudents() {

        return repository.getStudents();
    }

    public void addStudent(Student student) {

        repository.addStudent(student);
    }

    public void deleteStudent(Long id) {

        repository.deleteStudent(id);
    }

    public Student getStudentById(Long id) {

        return repository.getStudentById(id);
    }

    public void updateStudent(Student student) {

        repository.updateStudent(student);
    }
}
