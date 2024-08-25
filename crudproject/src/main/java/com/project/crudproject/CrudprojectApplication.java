package com.project.crudproject;

import com.project.crudproject.DAO.StudentDAO;
import com.project.crudproject.DAO.StudentDAOImple;
import com.project.crudproject.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectApplication.class, args);
	}

	//for creating a command line application
	@Bean //CommandLineRunner is from springboot framework, so it will run after the beans have loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		 return runner ->{
//			 createStudent(studentDAO);
		 createmultiplestudents(studentDAO);
			 //readStudent(studentDAO);
			 //queryForStudents(studentDAO);
//			 queryForStudentsBylastName(studentDAO);
//			 updateStudent(studentDAO);

			 //deleteStudent(studentDAO);
		 };
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("deleting student with id"+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on id
		int studentId=1;
		System.out.println("getting student with id"+studentId);
		Student mystudent = studentDAO.findById(studentId);

		//change first  name
		System.out.println("Updating student");
		mystudent.setFirstname("Taylor");

		//update the student
		studentDAO.update(mystudent);

		//display the updates student
		System.out.println("updated student"+mystudent);
	}

	private void queryForStudentsBylastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> thestudents = studentDAO.findByLastname("Swift");


		//display list of students
		for(Student tempstudent: thestudents){
			System.out.println(tempstudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display the list of students
		for(Student tempStudent :theStudents){
			System.out.println(tempStudent);

		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student");
		Student tempStudent= new Student("Awesome","Singer","singing@gmail.com");

		//save the student
		System.out.println("Saving the new student");
		studentDAO.save(tempStudent);


		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Saved student of id"+ theId);


		//retrieve student based on the id
		System.out.println("Retrieving student with id"+theId);
		Student myStudent = studentDAO.findById(theId);


		//display student

		System.out.println("Found the student"+myStudent);
	}

	private void createmultiplestudents(StudentDAO studentDAO) {

		//create multiple student objects
		//create student object
		System.out.println("Creating a new student");
		Student tempStudent1 = new Student("Ed","Sheeran","cruelsummer@gmail.com");
		Student tempStudent2 = new Student("Selena","Gomez","cruelsummer@gmail.com");
		Student tempStudent3 = new Student("Justin","Bieber","cruelsummer@gmail.com");

		//save student objects
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {


		//create student object
		System.out.println("Creating a new student");
		Student tempStudent = new Student("Taylor","Swift","cruelsummer@gmail.com");

		//save the student object
		System.out.println("Saving the student now");
		studentDAO.save(tempStudent);



		// display id of the saved student object
		System.out.println("The id of teh saved student is"+ tempStudent.getId());
	}


}
