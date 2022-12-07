package com.bank.account.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bank.account.entity.StudentEntity;

@Service
public interface StudentService {

	List<StudentEntity> getAllStudents();
	
	StudentEntity saveStudent(StudentEntity student);
	
	public StudentEntity getStudentById(Long student_id);
	
	StudentEntity updateStudent(StudentEntity student);
	
	void deleteStudentById(Long student_id);
}
