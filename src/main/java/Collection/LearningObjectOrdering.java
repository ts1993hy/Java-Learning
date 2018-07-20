package Collection;

import java.util.*;

public class LearningObjectOrdering {


    static final Comparator<Integer> SENIORITY_ORDER = new Comparator<Integer>() {
        public int compare(Integer e1, Integer e2) {
            return e2.compareTo(e1);
        }
    };

    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < 10 ; i++){
            list.add(random.nextInt(20));
        }
        System.out.println(list);
        Collections.sort(list,SENIORITY_ORDER);
        System.out.println(list);
    }

}
