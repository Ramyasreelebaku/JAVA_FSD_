package com.hexaware.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.app.Dao.RepStudent;
import com.hexaware.app.Entity.Student;

@Service
public class StudentService {
	@Autowired
	RepStudent RepSt;

	public Student saveSt(Student s)

	{
		Student s2 = RepSt.save(s);
		return s2;
	}

	public String getStudNameById(int rollNm) {
		Student s = RepSt.findById(rollNm).orElse(null);
		if (s == null) {
			return "Student not found";
		} else {
			return s.getName();
		}
	}

	public Student getStudById(int rollNm) throws Exception {

		Student s = RepSt.findById(rollNm).orElseThrow(() -> new Exception("not found " + rollNm));
		if (s == null) {
			return null;
		} else {
			return s;
		}

	}

	public List<Student> getStuds() {
		List<Student> l = (List) RepSt.findAll();
		return l;
	}

	public Student removeSd(int rno) throws Exception {
		Student s = RepSt.findById(rno).orElseThrow(() -> new Exception(" Not found"));
		if (s == null) {
			return null;
		}

		else {

			RepSt.delete(s);
		}

		return s;

	}

	public String updateSt(int rn, String nm) {
		Student s = RepSt.findById(rn).orElse(null);
		if (s == null) {
			return "not found";
		}

		else {

			s.setName(nm);
			RepSt.save(s);
			return "name updated";
		}

	}

	public String searchRoll(int r) throws Exception {
		Student s = RepSt.findById(r).orElseThrow(() -> new Exception(" not found"));

		return s.getName();
	}

	public Student createStudent(Student newStudent) {
		try {
			return RepSt.save(newStudent);
		} catch (Exception e) {
			throw new RuntimeException("Failed to create student", e);
		}
	}

	public String updateStudentName(int id, String newName) {
		try {
			Optional<Student> existingStudentOpt = RepSt.findById(id);

			if (existingStudentOpt.isPresent()) {
				Student existingStudent = existingStudentOpt.get();
				existingStudent.setName(newName);
				RepSt.save(existingStudent);
				return "Student updated successfully";
			} else {
				return "Student not found";
			}

		} catch (RuntimeException e) {
			return "Internal server error";
		}
	}

	public List<Student> getAllStudents() {
		return (List<Student>) RepSt.findAll();
	}

	public int updateInfo(double bal, int ano) {

		int k = RepSt.updaleBal(bal, ano);
		return k;

	}
	
	public List<Student> findByNameContaining(String Name) {
        return RepSt.findByNameContaining(Name);
    }
	
	public List<Student> findByAgeRange(int minAge, int maxAge) {
        return RepSt.findStudentsByAgeRange(minAge, maxAge);
    }
}
