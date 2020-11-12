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

    public int getAge()
    {
        return super.age;
    }

    public Student(String Name, String Surname, int Age, int Mark, Organizations Unik) {
        super(Name, Surname, Age);
        mark = Mark;
        unik = Unik;
    }
    @Override public  String toString() {
        return super.name +" " +  super.surname+ " " + super.age + " " + mark + " " + unik.getCountStud();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    static public Optional<String > SomeData(Student stud)
    {
        return Optional.ofNullable(stud.surname);
    }

}
