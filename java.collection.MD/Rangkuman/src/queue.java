import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
    //     Queue<String> names = new ArrayDeque<>(10);
    //     names.offer("Khansa");

    //     for (String next = names.poll(); next != null; next= names.poll() );
    //     System.out.println(names);
    // }
    Deque<String> names = new ArrayDeque<>();
    names.offerLast("khansa");
    names.offerLast("Nana");

    for(String next = names.pollLast(); next != null; next = names.pollLast()){
        System.out.println(next);
    }
    
}

}
