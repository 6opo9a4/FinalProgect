package Desk;

import Lectors.Lector;

public class Postpon {
    public Lector lek;
    public String less;
    public String time;
    public String comment;
    public String data;

    public Postpon(){}
    public Postpon(Lector Lek, String Less, String Time,String Comment, String Data){
        this.lek=Lek;
        this.less=Less;
        this.time=Time;
        this.comment =Comment;
        this.data = Data;
    }
}
