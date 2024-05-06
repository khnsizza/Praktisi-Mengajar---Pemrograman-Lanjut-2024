import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class list {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        // List<String> names = new LinkedList<>();

        names.add("Khansa");
        names.add("Nana");

        for (var name: names){
            System.out.println(names);

        }

    }
}
