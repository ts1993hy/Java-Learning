package Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LearningSet<T>{

    /*
    * Java平台包含三个通用Set实现：HashSet，TreeSet，和LinkedHashSet。
    * 1. HashSet，将其元素存储在哈希表中，是性能最佳的实现; 但是对于迭代次序没有任何保证。
    * 2. TreeSet，它将元素存储在红黑树中，根据它们的值排列元素; 它大大低于HashSet。
    * 3. LinkedHashSet是作为一个散列表来实现的，其中有一个贯穿其中的链表，它根据元素插入到集合中的顺序(插入顺序)对其元素进行排序。
    * LinkedHashSet的访问顺序和插入顺序一致，代价只比HashSet高一点点。
    * */
    private Set<T> set;

    public Set<T> getSet(){
        if (set == null) set = new HashSet<>();
        return set;
    }

    public void setSet(Collection<T> c){
        //set = new HashSet<>(c);
        set = c.stream().collect(Collectors.toSet());
    }

    /*
    *   批量操作特别适合Set;应用时，它们执行标准的集代数运算。假设s1和s2是集合。
    *   s1.addall(s2)—将s1转换为s1和s2的联合。(两个集合的并集是包含两个集合中的所有元素的集合。)
    *   s1.retainall(s2)—将s1转换为s1和s2的交点。(两个集合的交集是只包含两个集合共同的元素的集合。)
    *   s1.removeall(s2)—将s1转换为s1和s2的(不对称)集差。(例如，s1 - s2的集合差是包含s1中所有元素的集合，而不是s2中所有元素的集合。)
    * */
    public Set<T> union(Set<T> c){
        Set<T> union = new HashSet<T>(c);
        union.addAll(set);
        return union;
    }

    public Set<T> intersection(Set<T> c){
        Set<T> intersection = new HashSet<T>(c);
        intersection.retainAll(set);
        return intersection;
    }

    public Set<T> difference(Set<T> c){
        Set<T> difference = new HashSet<T>(c);
        difference.removeAll(set);
        return difference;
    }

}
