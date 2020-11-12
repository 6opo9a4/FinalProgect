package People;

import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Optional;

import Organization.Organizations;

public class Manager extends Pesrson implements Serializable {
    public Organizations unik;
    public String url;

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

    public Manager(String Name, String Surname,String Middlename, int Age, Organizations Unik,String Email,String Number,String Url) {
        super(Name, Surname,Middlename, Age,Email,Number);
        unik = Unik;
        url = Url;
    }
    public Manager() { }



    @Override public  String toString() {
        return super.name +" " +  super.surname+ " "  + super.middlename + " " + super.age + " " + unik.getCountStud();
    }


}
