package Organization;


public enum Organizations {
    BSTU(new String[]{"IT","LesHoz","CHemistry"},5,"BSTU"),
    BSU(new String[]{"HZ","NE ZNAYU"},7,"BSU"),
    PED(new String[]{"Filologiya","Matem","Fizka"},3,"PED");

    String[] Faciltie;
    int count;
    String Org;


    Organizations(String[] faculties, int Count, String org) {
        this.Faciltie = faculties;
        this.count =Count;
        this.Org = org;
    }

    public int getCountStud()
    {
        return count;
    }
    public  String getOrg(){
        return  Org;
    }

}
