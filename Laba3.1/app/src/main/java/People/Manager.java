package People;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.Optional;

import Organization.Organizations;

public class Manager extends Pesrson implements Serializable {
    public Organizations unik;

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

    public Manager(String Name, String Surname,String Middlename, int Age, Organizations Unik) {
        super(Name, Surname,Middlename, Age);
        unik = Unik;
    }
    public Manager() { }



    @Override public  String toString() {
        return super.name +" " +  super.surname+ " "  + super.middlename + " " + super.age + " " + unik.getCountStud();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    static public Optional<String > SomeData(Student stud)
    {
        return Optional.ofNullable(stud.surname);
    }
}
