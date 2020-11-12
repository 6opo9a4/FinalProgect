package Organization;


public enum Organizations {
    BSTU(new String[]{"IT","LesHoz","CHemistry"},5),
    BSU(new String[]{"HZ","NE ZNAYU"},7),
    PED(new String[]{"Filologiya","Matem","Fizka"},3);

    String[] Faciltie;
    int count;

    Organizations(String[] faculties, int Count) {
        this.Faciltie = faculties;
        this.count =Count;
    }

    public int getCountStud()
    {
        return count;
    }

}
