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
            Arrays.asList(1,49,32,21,12,43,23,43,234,23,5,7,867,4,3,23,65,345,756,45,100);

}