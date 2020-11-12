package People;

import java.io.Serializable;
import java.util.ArrayList;

public class JManager implements Serializable {

   public ArrayList<Manager> persrs;
    public JManager(ArrayList<Manager> Persrs)
    {
        this.persrs = Persrs;
    }

    public JManager() {}
}
