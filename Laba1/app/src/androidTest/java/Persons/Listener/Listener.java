package Persons.Listener;

import java.util.List;

public class Listener extends Persons.Person
{
    int Mark;
    public List<Listener> Listeners;
    public Listener(String Name,String Surname ,int Age, int Mark)
    {
        super(Name, Surname, Age);
        this.Mark=Mark;
    }
}
