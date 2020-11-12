package People;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Comparators.Stusentsomparator;
import Comparators.StusentsomparatorAge;
import Comparators.StusentsomparatorName;
import Organization.Organizations;

public class Manager
{
      public void make(ArrayList<Student> stud, int pre)
      {
            stud.clear();
            for(int i = 0; i< pre;i++)
            {
                int a = (int) (Math.random() * 5);
                int age = (int) (17 + Math.random() * 40);
                int b = (int) (Math.random() * 8);
                int c = (int) (Math.random() * 8);
                int e = (int) (Math.random() * 3);
                Organizations org;
                switch (e)
                {
                    case 1:
                        stud.add(new Student("" + a,"" + b, age,c,org = Organizations.BSTU));
                        break;
                    case 2:
                        stud.add(new Student("" + a,"" + b, age,c,org = Organizations.BSU));
                        break;
                    case 0:
                        stud.add(new Student("" + a,"" + b, age , c ,org = Organizations.PED));
                        break;
                }

            }

      }

    public void markSort(ArrayList<Student> ITs,ArrayList<String> stringStudIT, int pre)
    {
        Comparator ageComparator = new Stusentsomparator();
        stringStudIT.clear();
        Collections.sort(ITs, ageComparator);
        for(int i =0;i<pre;i++)
        {
            String second_stud = ITs.get(i).toString();
            stringStudIT.add(second_stud);
        }
//        Log.d("Log_02");
    }

    public void nameSort(ArrayList<Student> ITs,ArrayList<String> stringStudIT, int pre)
    {
        Comparator ageComparator = new StusentsomparatorName();
        stringStudIT.clear();
        Collections.sort(ITs, ageComparator);
        for(int i =0;i<pre;i++)
        {
            String second_stud = ITs.get(i).toString();
            stringStudIT.add(second_stud);
        }
    }

    public void ageSort(ArrayList<Student> ITs,ArrayList<String> stringStudIT, int pre)
    {
        Comparator ageComparator = new StusentsomparatorAge();
        stringStudIT.clear();
        Collections.sort(ITs, ageComparator);
        for(int i =0;i<pre;i++)
        {
            String second_stud = ITs.get(i).toString();
            stringStudIT.add(second_stud);
        }
    }


}
