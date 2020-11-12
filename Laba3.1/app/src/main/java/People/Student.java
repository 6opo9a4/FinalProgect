package People;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Optional;

import Organization.Organizations;

public class Student extends Pesrson implements Serializable{
    public int mark;
    Organizations unik;


    public int getMark()
    {
        return mark;
    }

    public String getName()
    {
        return super.name;
    }
    public String getMiddlename()
    {
        return super.middlename;
    }

    public int getAge()
    {
        return super.age;
    }

    public Student(String Name, String Surname,String Middlename, int Age, int Mark, Organizations Unik) {
        super(Name, Surname,Middlename, Age);
        mark = Mark;
        unik = Unik;
    }
    public Student() { }

    @Override public  String toString() {
        return super.name +" " +  super.surname+ " "  + super.middlename + " " + super.age + " " + mark + " " ;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    static public Optional<String > SomeData(Student stud)
    {
        return Optional.ofNullable(stud.surname);
    }

}
