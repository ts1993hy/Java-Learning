package Collection;

import java.util.Iterator;
import java.util.Map;

/*
 * Map是将键映射到值的对象。Map不能包含重复键：每个键最多可映射一个值。
 * 所述Map接口包括用于基本操作的方法（如put，get，remove， containsKey，containsValue，size，和empty），
 * 批量操作（如putAll和clear），以及集合视图（如keySet，entrySet，和values）。
 * Java平台包含三个通用映射实现:HashMap、TreeMap和LinkedHashMap。
 * 它们的行为和性能与Set接口部分中描述的HashSet、TreeSet和LinkedHashSet类似。
 * Map的基本操作(put、get、containsKey、containsValue、size和isEmpty)与HashTable中的对应操作完全相同。
 * 与Set和 List接口一样 ，Map增强了对equals和hashCode方法的要求，以便Map可以比较两个对象的逻辑相等性，而不考虑它们的实现类型。
 * Map中如果两个实例表示相同的键值映射，则它们是相等的。Map实现提供的构造函数在功能和方式上和Collection类似。
 * clear操作删除所有映射。putAll操作和Collection接口的addAll操作相似。
 * 集合视图
 * 该Collection视图方法允许Map在这三个方面被视为Collection：
 * keySet- Set包含在中的Key Map。
 * values- 包含在映射中的值的集合。这Collection不是Set，因为多个键可以映射到相同的值。
 * entrySet- 映射中包含的键值对的集合。Map接口提供了一个名为Map.Entry的小嵌套接口。
 * */
public class LearningMap<K,V> {

    public void iterator(Map<K,V> map){
        /*
        * 第一种遍历方法
        * */
        for(K key:map.keySet())
            System.out.println(key);
        /*
        * 第二种遍历方法，只有这种通过迭代器的方式可以删除元素
        * */
        for (Iterator<K> it = map.keySet().iterator(); it.hasNext(); ){
            it.next();
            it.remove();
        }
        /*
        * 最初许多人担心这些习惯用法可能很慢，因为每次调用Collection view操作时，Map都必须创建一个新的Collection实例。
        * 别担心，没有理由说映射不能总是在每次请求一个给定的集合视图时返回相同的对象。这正是java.util中Map的实现类做的。
        * */
        for (Map.Entry<K,V> e : map.entrySet())
            System.out.println(e.getKey() + ": " + e.getValue());
    }
    /*
    * 使用entrySet视图，还可以通过在迭代期间调用Map.Entry的setValue方法来更改与键关联的值（同样，假设Map支持值修改以开始）。
    * 请注意，这些是在迭代期间修改Map的唯一安全方法; 如果在迭代进行过程中以任何其他方式修改基础Map，则行为未指定。
    * Collection视图支持以多种形式删除元素 - remove，removeAll，retainAll和clear操作，以及Iterator.remove操作。 (同样，这假设Map支持元素删除。)
    * 集合视图的Fancy用法：Map代数
    * */
}
