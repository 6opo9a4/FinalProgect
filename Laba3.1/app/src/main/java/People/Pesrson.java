package People;
import java.io.Serializable;

public class Pesrson implements Serializable {
    public String name;
    public String surname;
    public String middlename;
    public int age;

    public Pesrson(String Name,String Surname,String Middlename,int Age)
    {
        this.name =Name;
        this.surname = Surname;
        this.middlename = Middlename;
        this.age = Age;
    }
    public Pesrson() { }

    @Override public  String toString() {
        return name +" " +  surname+ " "  + middlename + " " + age;
    }

}
