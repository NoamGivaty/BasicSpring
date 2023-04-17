package com.basicSpring.repo;


import com.basicSpring.model.StudentGrade;
import org.springframework.data.repository.CrudRepository;

public interface StudentGradeRepository extends CrudRepository<StudentGrade,Long> {

}
