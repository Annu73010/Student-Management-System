package com.bank.account.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.account.entity.StudentEntity;
import com.bank.account.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentrepository;
	
	@Override
	public List<StudentEntity> getAllStudents() {
		return studentrepository.findAll();
	}

	@Override
	public StudentEntity saveStudent(StudentEntity student) {
		return studentrepository.save(student);
	}

	@Override
	public StudentEntity getStudentById(Long student_id) {
		return studentrepository.findById(student_id).get();
	}

	@Override
	public StudentEntity updateStudent(StudentEntity student) {
		return studentrepository.save(student);
	}

	@Override
	public void deleteStudentById(Long student_id) {
		studentrepository.deleteById(student_id);
	}

	
}
