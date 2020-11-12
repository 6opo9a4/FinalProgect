package Lectors;

import java.io.Serializable;
import java.util.ArrayList;

public class JLectorsCol implements Serializable {
    ArrayList<Lector> lector;
    public JLectorsCol()
    {}
    public JLectorsCol(ArrayList<Lector> Lec)
    {
        this.lector = Lec;
    }
}
