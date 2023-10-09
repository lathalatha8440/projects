package sdbms;
//interface
public interface StudentManagementSystem {
	void addStudent();
	void displayStudent();
	void  displayAllStudents();
	void removeStudent();
	void removeAllStudents();
	void findStudentWithHighestMarks();
	void findStudentWithLowestMarks();
	void updateStudent();
	void countStudent();
	void sortStudent();


}


//All the methods inside interface are automatically public and interface