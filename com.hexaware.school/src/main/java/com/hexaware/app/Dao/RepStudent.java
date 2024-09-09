package com.hexaware.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexaware.app.Entity.Student;

@Repository
public interface RepStudent extends JpaRepository<Student, Integer>{
	
	@Modifying
	@Query(value="update student set fee=:f where roll=:r",nativeQuery=true)
	public int updaleBal(@Param("f") double b, @Param("r")int a);
	
	public List<Student> findByNameContaining(String name);
	
	@Query("SELECT s FROM Student s WHERE s.age BETWEEN :minAge AND :maxAge")
    List<Student> findStudentsByAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

}
