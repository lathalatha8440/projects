package sdbms;
import java.util.Scanner;
import customException.InvalidChoiceException;
public class StudentMainclass {

	public static void main(String[] args) {
		System.out.println("Welcome to student Database project");
		System.out.println("-------------------");	
		Scanner sc=new Scanner(System.in)	;
		
		//upcasting for achieve absraction
		StudentManagementSystem s=new StudentManagementSystemImp();
		while(true)//infinite loop
		{
			//Menu driven program
			System.out.println("1.addStudent");
			System.out.println("2.countStudent");
			System.out.println("3.displayStudent");
			System.out.println("4.displayAllStudents");
			System.out.println("5.findStudentWithHighestMarks");
			System.out.println("6.findStudentWithLowestMarks");
			System.out.println("7.removeStudent");
			System.out.println("8.removeAllStudents");
			System.out.println("9.sortStudent");
			System.out.println("10.updateStudent");
			System.out.println("11.Exit");
			int choice=sc.nextInt();

			switch(choice)	
			{
			case 1:
				s.addStudent();
				break;
			case 2:
				s.countStudent();
				break;
			case 3:
				s.displayStudent();
				break;
			case 4:
				s.displayAllStudents();
				break;
			
			case 5:
				s.findStudentWithHighestMarks();
				break;
			case 6:
				s.findStudentWithLowestMarks();
				break;
			case 7:
				s.removeStudent();
				break;
			case 8:
				s.removeAllStudents();
				break;
			case 9:
				s.sortStudent();
				break;
			case 10:
				s.updateStudent();
				break;
			case 11:
				System.out.println("Thank you!!");
			default :
				try
				{
					String message="Invalid choice,Enter valid choice";
					throw new InvalidChoiceException("Invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		
			}//end of switch
			
			System.out.println("--------");
			
		}//end of while


	}//end of main

}//end of class
