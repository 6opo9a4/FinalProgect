package Persons.Student;

import java.util.List;

public class Student extends Persons.Person
{

    public List<Student> Studlist;

    public Student(String Name, int Age, String Surname) {
        super(Name, Surname, Age);
    }
}
