package com.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.account.entity.StudentEntity;


public interface StudentRepository extends JpaRepository<StudentEntity,Long>{

}
