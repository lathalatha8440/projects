package sdbms;

import java.util.Comparator;

public class SortStudentById implements Comparator<Student>{
	@Override

	public int compare(Student x,Student y)
	{
		return x.getId().compareTo(y.getId());
	}
}


//x-->object to be inserted
//y-->already existing object
//for string comparision,we need to call compareTo() string class