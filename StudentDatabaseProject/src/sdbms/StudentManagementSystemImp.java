package sdbms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.InvalidChoiceException;
import customException.StudentNotFoundException;
//interface
public class StudentManagementSystemImp implements StudentManagementSystem  {
	Scanner sc=new Scanner(System.in);
	//key-->Student id&value---->Student object;

	Map<String,Student> db=new LinkedHashMap<String,Student> ();
	@Override
	public void addStudent() {

		//Accepting Name
		System.out.println("Enter Name");
		String name=sc.next();

		//Accepting Age
		System.out.println("Enter age");
		int age=sc.nextInt();

		//Accepting Marks
		System.out.println("Enter Marks");
		int marks=sc.nextInt();

		//Create a student instance
		Student std=new Student(age,name,marks);

		//Adding entry in a db(map)
		db.put(std.getId(),std);

		//print Statement id
		System.out.println("Student id is "+std.getId());
		System.out.println("Student record inserted successfully");
	}

	@Override
	public void displayAllStudents() {
		if(!db.isEmpty())
		{
			System.out.println("Student record are as follows");
			System.out.println("--------------");
			Set<String>keys=db.keySet();  //jsp101,jsp102
			for(String key:keys)
			{
				Student std=db.get(key);  //getting student object
				System.out.println(std);  //toString()is overridden
				//System.out.println(db.get(key))
			}
		}
		else
		{
			try {
				String message="No Students recordds to Display!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayStudent() {
		//Accept student id
		System.out.println("Enter Student id:");
		//convert toUpperCase
		String id=sc.next();  //String id=sc.next().toUpperCase
		id=id.toLowerCase();
		//check if id present or not--->(id==key)
		if(db.containsKey(id))
		{
			System.out.println("Student record Found");
			System.out.println("Student details are as follows");
			System.out.println("-----------------------");
			Student std=db.get(id);//getting student object based on id
			System.out.println("Id:"+std.getId());
			System.out.println("Name:"+std.getName());
			System.out.println("Age:"+std.getAge());
			System.out.println("Marks:"+std.getMarks());
			//printing reference variable as toStirng() is overridden
			//System.out.println(std);
		}
		else
		{
			try {
				String message="Student with Id"+id+"is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}  
	@Override
	public void findStudentWithHighestMarks() {
    List<Student>list=new ArrayList<Student>();
    Set<String>keys=db.keySet();
    for(String key:keys)
    {
    	list.add(db.get(key));//adding student object from map into list
    }
    Collections.sort(list,new SortStudentByMarks());
    System.out.println("Students with highest marks");
    System.out.println(list.get(list.size()-1));
	}

	@Override
	public void findStudentWithLowestMarks() {
		 List<Student>list=new ArrayList<Student>();
		    Set<String>keys=db.keySet();
		    for(String key:keys)
		    {
		    	list.add(db.get(key));//adding student object from map into list
		    }
		    Collections.sort(list,new SortStudentByMarks());
		    System.out.println("Students with Lowest marks");
		    System.out.println(list.get(0));

	}

	@Override
	public void removeStudent() {
		System.out.println("Enter student id");//Acceptind id
		String id=sc.next().toLowerCase();

		if(db.containsKey(id))
		{
			System.out.println("Student record Found");
			System.out.println(db.get(id));//printing student object
			db.remove(id); //removing the entry(key&value)
			System.out.println("Student record Deleted successfully");
		}
		else
		{
			try
			{
				String message="Student with Id "+id+" is not Found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
    if(!db.isEmpty())
    {
    	System.out.println("no of Students Records:"+db.size());
    	db.clear();
    	System.out.println("All Students are Deleted Successfully..!");
    }
    else
    {
     try
     {
    	 String message="No Students records to display!";
    	 throw new StudentNotFoundException(message);
     }
     catch(Exception e)
     {
 		System.out.println(e.getMessage());	 
     }
    }

	}


	@Override
	public void updateStudent() {
     System.out.println("Enter student ID:");
     String id=sc.next().toUpperCase();
     if(db.containsKey(id))
     {
    	 System.out.println("Student record found");
    	 Student std=db.get(id);//getting student 
    	 System.out.println("1.Update Age\n2.Update Name\n3.Update Marks\nEnter Choice");
    	 int choice=sc.nextInt();
    	 
    	 switch(choice)
    	 {
    	 case 1:
    		 System.out.println("Enter age");
    		 int age=sc.nextInt();
    		 std.setAge(age);//std.setAge(sc.nextInt());
    		 System.out.println("Student Age updated successfully");
    		 break;
    		 
    	 case 2:
    		 System.out.println("Enter Name"); 
    		 String name=sc.next();
    		 std.setName(name); //std.setName(sc.next());
    		 System.out.println("Student Name updated successfully");
    		 break;
    		 
    	 case 3:
    		 System.out.println("Enter Marks"); 
    		 int marks=sc.nextInt();
    		 std.setMarks(marks); //std.setMarks(sc.nextInt());
    		 System.out.println("Student Marks updated successfully");
    		 break;
    		 
    		 default:
    			 try
    			 {
    				 String message="invalid choice ,please enter valid choice";
    				 throw new InvalidChoiceException(message);
    			 }
    			 catch(Exception e)
    			 {
    				 System.out.println(e.getMessage());
    			 }
    	 }
     }
     try
     {
    	 String message="Student with"+id+" is not found:";
    	 throw new StudentNotFoundException(message);
     }
  catch(Exception e)
     {
	  System.out.println(e.getMessage());
     }
	}

	@Override
	public void countStudent() {
		System.out.println("Number of Students"+db.size());
}

	@Override
	public void sortStudent() {

		List<Student>list=new ArrayList<Student>();
		
		//converting map into set which stores keys(Id)
		Set<String>keys=db.keySet();
		
		//traversing keys
		for(String key:keys)
		{
			//sorting values(student object)& and adding it into list
			list.add(db.get(key));
		}
		System.out.println("1.Sort Student By Id\n2.Sort Student By Age\n3.Sort Student By Name\n4.Sort Student By Marks ");
        int choice=sc.nextInt();
        
        switch(choice)
        {
        
        case 1:
        	Collections.sort(list,new SortStudentById());
        	for(Student s:list)
        	{
        		System.out.println(s);
        	}
        	break;
        case 2:
        	Collections.sort(list,new SortStudentByAge());
        	for(Student s:list)
        	{
        		System.out.println(s);
        	}
        	break;
        case 3:
        	Collections.sort(list,new SortStudentByName());
        	for(Student s:list)
        	{
        		System.out.println(s);
        	}
        	break;
        case 4:
        	Collections.sort(list,new SortStudentByMarks());
        	for(Student s:list)
        	{
        		System.out.println(s);
        	}
        	break;
        	default:
        		try {
        			String message="Invalid choice,please enter valid choice";
        			throw new InvalidChoiceException(message);
        		}
        		catch(Exception e)
        		{
        			System.out.println(e.getMessage());
        		}
        	
        }
	}



}
