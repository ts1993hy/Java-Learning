package Collection;

import java.util.*;

/*
* SortedSet是一个Set，它按升序维护其元素，根据元素的自然顺序或根据SortedSet创建时提供的Comparator进行排序。
* 除了Set的常规操作外，SortedSet接口还提供以下操作：
* Range view - 对已排序的Set执行任意范围操作
* Endpoints  - 返回有序Set中的第一个或最后一个键
* Comparator access - 返回用于对Set进行排序的比较器（如果有）
* public interface SortedSet<E> extends Set<E> {
*    // Range-view
*    SortedSet<E> subSet(E fromElement, E toElement);
*    SortedSet<E> headSet(E toElement);
*    SortedSet<E> tailSet(E fromElement);
*
*    // Endpoints
*    E first();
*    E last();
*
*    // Comparator access
*    Comparator<? super E> comparator();
*}
* 一、Set的操作
* SortedSet从Set继承的操作在排序Set和普通Set上的行为相同，但有两个例外：
* 1.迭代器操作返回的迭代器按顺序遍历有序集。
* 2.toArray返回的数组按顺序包含有序集的元素。
* 虽然接口不保证它，但Java平台的SortedSet实现的toString方法按顺序返回包含有序集的所有元素的字符串。
* 二、标准构造器
* 按照惯例，所有通用Collection实现都提供了一个带有Collection的标准转换构造函数，SortedSet实现也不例外。
* 在TreeSet中，此构造函数创建一个实例，根据其自然顺序对其元素进行排序。
* 构造器接受实现Collection接口的和实现SortedSet，如果传入实现SortedSet接口的实例，使用该SortedSet的Comparator的实例，这儿很容易导致错误，需要注意。
* 三、Range-View操作
* Range-View操作有点类似于List接口提供的操作，但是又有很大的区别。如果直接修改了原集合，Range-View也会发生相应的改变。
* 排序集的Range-View实际上只是集合的任何部分位于元素空间的指定部分中的窗口。
* 对范围视图的更改将写回到后备排序集，反之亦然。 因此，与列表上的范围视图不同，可以长时间在有序集上使用范围视图。
* 排序集提供三种范围视图操作。视图操作中不能插入、删除视图范围外的元素。
* 1.subSet，其与subList一样，范围是半开放的，包括其低端点但不包括高端点。
* 2.headSet，范围是半开放的，包括其低端点但不包括高端点。
* 3.tailSet，范围是半开放的，包括其低端点但不包括高端点。

* 该SortedSet接口包含操作的有序集合返回第一个和最后一个元素，函数first和last
*
* */
public class LearningSortedSet {

    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        //Random random = new Random();
        for(int i = 1 ; i < 20 ; i++){
            //sortedSet.add(random.nextInt(100));
            sortedSet.add(i);
        }
        System.out.println(sortedSet);
        SortedSet<Integer> rangeSet = sortedSet.subSet(10,20);
        SortedSet<Integer> headSet = sortedSet.headSet(12);
        SortedSet<Integer> tailSet = sortedSet.tailSet(12);
        sortedSet.remove(12);
        System.out.println(rangeSet);
        System.out.println(headSet);
        System.out.println(tailSet);
        System.out.println(sortedSet);
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < 20 ; i++){
            //sortedSet.add(random.nextInt(100));
            list.add(i);
        }
        List<Integer> tmp = list.subList(10,19);
        //list.remove(12);
        System.out.println(tmp);

    }

}
