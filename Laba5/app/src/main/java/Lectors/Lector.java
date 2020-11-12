package Lectors;

import android.util.LruCache;

import com.example.laba5.R;

import java.io.Serializable;

public class Lector implements Serializable {
    public String name;
    public String surname;
    public String faculti;
    public Object photo;

    public Lector()
    {}
    public Lector(String Name, String Surname, String Faculti, Object Photo)
    {
        this.name = Name;
        this.surname = Surname;
        this.faculti = Faculti;
        this.photo =Photo;
    }

//    public Lector odin = new Lector("Perwyi","1","Memologia",R.drawable.download1);
//    public Lector dwa = new Lector("Wtoroy","2","Trilliriwanie",R.drawable.download2);
//    public Lector tri = new Lector("Tretyi","3","Chill",R.drawable.download3);
//    public Lector chetyre = new Lector("Chetwertyi","4","Prokrastination",R.drawable.download4);
//    public Lector pyat = new Lector("Pyatyi","5","Design",R.drawable.download5);
}
