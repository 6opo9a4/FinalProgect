package Comparators;

import java.util.Comparator;

import People.Student;

public class StusentsomparatorName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2)
    {
        if(o1.getName() == o2.getName())
        {
            return o1.getMark() - o2.getMark();
        }
        else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
