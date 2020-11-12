package People;

import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Optional;

import Organization.Organizations;

public class Student extends Pesrson implements Serializable{
    public int mark;
    public Organizations unik;
    public String url;


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

    public Student(String Name, String Surname,String Middlename, int Age, int Mark, Organizations Unik,String Email, String Number, String Url) {
        super(Name, Surname,Middlename, Age,Email ,Number);
        mark = Mark;
        unik = Unik;
        url = Url;
    }
    public Student() { }

    @Override public  String toString() {
        return super.name +" " +  super.surname+ " "  + super.middlename + " " + super.age + " " + mark + " " ;
    }

}
