package Comparators;

public interface DefSerialize {

    default String information1() {
        return "Compare by mark";
    }

    static String information2() {
        return "Compare by mark";
    }
}
