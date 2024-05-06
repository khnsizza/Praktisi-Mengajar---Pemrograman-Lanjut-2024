import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
public class iterable {
    public static void main(String[] args) throws Exception {
    //    Iterable<String> names = List.of("Khansa","Aulia");


    //    for (var name: names){
    //     System.out.println(name);
    //    }

    Collection<String> names = new ArrayList<>();
    names.add ("Khansa");
    names.add("Aulia");
    names.addAll(Arrays.asList("Khansa", "Aulia", "Izza"));

    names.remove("Khansa");
    
    System.out.println(names.contains("Khansa"));


    for (var name: names){
        System.out.println(name);
    }
       
    }
}
