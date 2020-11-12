package People;
import java.io.Serializable;
public abstract class Pesrson implements Serializable {
    public String name;
    public String surname;
    public int age;

    public Pesrson(String Name,String Surname,int Age)
    {
        this.name =Name;
        this.surname = Surname;
        this.age = Age;
    }

}
