package Comparators;

import android.util.Log;

import java.util.Comparator;
import java.util.List;

import People.Student;

public class Stusentsomparator implements Comparator<Student> , DefSerialize {

    @Override
    public int compare(Student o1, Student o2)
    {
        String s2 = DefSerialize.information2();
        if(o1.getMark() == o2.getMark())
        {
            String s = DefSerialize.information2();
            return (o1.getAge()-o2.getAge());

        }
        else

            return (o1.getMark()-o2.getMark());


    }

}






































































































