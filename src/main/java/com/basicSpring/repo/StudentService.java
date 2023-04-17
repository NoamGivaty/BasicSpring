package com.basicSpring.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.basicSpring.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public Iterable<Student> all() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }


    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Student student) {
        repository.delete(student);
    }

    public List<Student> getStudentWithSatHigherThan(Integer sat) {
        return repository.findAllBySatScoreGreaterThan(sat);
    }

}