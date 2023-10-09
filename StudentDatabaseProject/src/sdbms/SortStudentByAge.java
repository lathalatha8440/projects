package sdbms;

import java.util.Comparator;

public class SortStudentByAge implements Comparator<Student> {
@Override
public int compare(Student x,Student y)
{
	return x.getAge()-y.getAge();
}
}


// x-->object to be inserted
// y-->already existing object
// for string comparision,we need to call compareTo() string class