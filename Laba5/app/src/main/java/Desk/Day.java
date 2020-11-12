package Desk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Day implements Serializable {
    public int day;
    public ArrayList<Lesson> lesso;

    public Day(){}
    public Day(int Day ,ArrayList<Lesson> Lesso)
    {
        this.day=Day;
        this.lesso=Lesso;
    }
}
