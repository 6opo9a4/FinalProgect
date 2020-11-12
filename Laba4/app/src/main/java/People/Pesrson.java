package People;
import java.io.Serializable;

public class Pesrson implements Serializable {
    public String name;
    public String surname;
    public String middlename;
    public String email;
    public String number;
    public int age;

    public Pesrson(String Name,String Surname,String Middlename,int Age,String Email, String Number)
    {
        this.name =Name;
        this.surname = Surname;
        this.middlename = Middlename;
        this.age = Age;
        this.email = Email;
        this.number = Number;
    }
    public Pesrson() { }

    @Override public  String toString() {
        return name +" " +  surname+ " "  + middlename + " " + age;
    }

}
