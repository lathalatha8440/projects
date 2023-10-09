package sdbms;

import java.util.Comparator;

public class SortStudentByMarks implements Comparator<Student> {
@Override
public int compare(Student x,Student y)
{
	return x.getMarks()-y.getMarks();
}
}



//x-->object to be inserted
//y-->already existing object
//for string comparision,we need to call compareTo() string class