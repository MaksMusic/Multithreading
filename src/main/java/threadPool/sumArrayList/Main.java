package threadPool.sumArrayList;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int sum = DataBase.arrayList.parallelStream().mapToInt(e-> e).sum();
        System.out.println(sum);
    }
}

class DataBase{
    static List<Integer> arrayList =
            Arrays.asList(1,49,77,21,12,43,27,43,234,23,5,7,867,7,12,23,65,345,756,45,100);

}