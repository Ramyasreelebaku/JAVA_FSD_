package com.hexaware.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.app.Entity.Student;
import com.hexaware.app.Service.StudentService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class StudentController {
	@Autowired
	StudentService studSer;
	
	@PostMapping("/saveStudent")
	Student saveStudent(@Valid @RequestBody Student s)
	{
		Student s2=studSer.saveSt(s);
		return s2;
		
	}
	
	/*@GetMapping("/getStudents")
	public List<Student> getStudent(){
		List<Student> users=studSer.getStuds();
		return users;
	}*/
	@GetMapping("/getStudentName/{rollNm}")
	public ResponseEntity<String> getStudentNameById(@PathVariable int rollNm) {
		try {
            String student = studSer.getStudNameById(rollNm);
 
            return new ResponseEntity<>(student, HttpStatus.OK);
 
        } catch (RuntimeException e) {
 
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
		
		
    }
	
	
	@GetMapping("/getStudent/{rollNm}")
	
	public ResponseEntity<Student> getStudentById(@PathVariable int rollNm) throws Exception {
        try {
            Student student = studSer.getStudById(rollNm);
 
            return new ResponseEntity<>(student, HttpStatus.OK);
 
        } catch (RuntimeException e) {
 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student newStudent) {
	    try {
	        Student student = studSer.createStudent(newStudent);
	        
	        return new ResponseEntity<>(student, HttpStatus.CREATED);

	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/updateStudentName/{id}/{nm}")
	public ResponseEntity<String> updateStudentName(@PathVariable int id, @PathVariable String nm) {
	    try {
	        String result = studSer.updateStudentName(id, nm);
	        
	        if ("Student updated successfully".equals(result)) {
	            return new ResponseEntity<>(result, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	        }

	    } catch (RuntimeException e) {
	        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
	    List<Student> students = studSer.getAllStudents();
	    
	    if (students.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } else {
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }
	}




	
	@DeleteMapping("removeStudent/{rno}")
	public Student removeStudent(@PathVariable int rno) throws Exception {
		Student s2=studSer.removeSd(rno);
		return s2;
	}
	
	@PutMapping("updateName/{rn}/{nm}")
	public String updateName(@PathVariable int rn, @PathVariable String nm) {
		String r=studSer.updateSt(rn, nm);
		return r;
	}
	
	@GetMapping("findName/{roll}")
	public String findName(@PathVariable int roll) throws Exception  {
		String r=studSer.searchRoll(roll);
		return r;
	}
	
	
	@Transactional
	 @PutMapping("/updatedatabyq/{f}/{r}")
	 public  String updateData1( @PathVariable double  f,  @PathVariable int  r ){
		String msg="";
		 int k=  studSer.updateInfo(f,r);
		 if(k>=1)
		 {
			 msg="Updated";
		 }
		 else
		 {
			 msg="not updated";
		 }
		 return (msg);
	 }
	@GetMapping("/find/{name}")
    public List<Student> findByNameContaining(@PathVariable String name) {
        return studSer.findByNameContaining(name);
    }
	
	@GetMapping("/students/{minAge}/{maxAge}")
	public List<Student> findByAgeRange(@PathVariable int minAge, @PathVariable int maxAge) {
	    return studSer.findByAgeRange(minAge, maxAge);
	}


}

