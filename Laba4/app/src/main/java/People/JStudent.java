package People;

import java.io.Serializable;
import java.util.ArrayList;

public class JStudent implements Serializable {
    public ArrayList<Student> persrs;

    public JStudent(ArrayList<Student> Persrs)
    {
        this.persrs = Persrs;
    }

    public JStudent() {}
}
