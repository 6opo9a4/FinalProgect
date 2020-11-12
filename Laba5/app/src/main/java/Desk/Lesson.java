package Desk;

import java.io.Serializable;

import Lectors.Lector;

public class Lesson implements Serializable {
    public Lector lek;
    public String less;
    public String time;
    public String comment;

    public Lesson(){}
    public Lesson(Lector Lek, String Less, String Time,String Comment){
        this.lek=Lek;
        this.less=Less;
        this.time=Time;
        this.comment =Comment;
    }
}
