package Desk;

import java.io.Serializable;
import java.util.ArrayList;

public class FirstWeek implements Serializable {
    public Day monday;
    public Day tuesday;
    public Day wednesday;
    public Day thursday;
    public Day friday;
    public Day saturday;

    public FirstWeek(){}
    public FirstWeek(Day Monday, Day Tuesday, Day Wednesday,Day Thursday,Day Friday,Day Saturday)
    {
        this.monday=Monday;
        this.tuesday=Tuesday;
        this.wednesday=Wednesday;
        this.thursday=Thursday;
        this.friday=Friday;
        this.saturday=Saturday;
    }
}
