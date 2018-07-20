package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
* List是有序的 Collection（有时称为序列）。列表可能包含重复元素。除了继承的操作外Collection，该List接口还包括以下操作：
* Positional access - 根据列表中的数字位置操纵元素。这包括方法，例如get， set，add，addAll，和remove。
* Search - 搜索列表中的指定对象并返回其数字位置。搜索方法包括 indexOf和lastIndexOf。
* Iteration - 扩展Iterator语义以利用列表的顺序性。这些 listIterator方法提供了这种行为。
* Range-view - 该sublist方法对列表执行任意范围操作。
* Java平台包含两个通用List实现。 ArrayList和LinkedList
* */
public class LearningList<T>{

    /*
    * 这是一个基于JDK 8及更高版本的例子，它将一些名称聚合成List：
    * List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
    * */
    public void addList(List<T> list1){
        List<T> list2 = new ArrayList<>();
        list2.addAll(list1);
    }

    /*
    * 正如您所期望的那样，Iterator返回List的iterator操作以适当的顺序返回列表的元素。
    * List还提供了一个更丰富的迭代器，称为a ListIterator，它允许您在任一方向遍历列表，在迭代期间修改列表，并获取迭代器的当前位置。
    * */
    public void iterator(List<T> list){
        ListIterator<T> iterator = list.listIterator();
        while(iterator.hasNext()){
            iterator.next();
        }
        while(iterator.hasPrevious()){
            iterator.previous();
        }
    }

    /*
    * Collections该类中的大多数多态算法专门适用于List。拥有所有这些算法可以很容易地操作列表。以下是这些算法的摘要，这些算法在“算法”部分中有更详细的描述。
    *   sort- List使用合并排序算法对a进行排序，该算法提供快速，稳定的排序。（稳定的排序是不重新排序相同元素的排序。）
    *   shuffle- 随机置换a中的元素List。
    *   reverse- 颠倒a中元素的顺序List。
    *   rotate- 将a中List的所有元素旋转指定的距离。
    *   swap- 将元素交换到a中的指定位置List。
    *   replaceAll - 将一个指定值的所有出现替换为另一个。
    *   fill- List用指定的值覆盖a中的每个元素。
    *   copy- 将源复制List到目标List。
    *   binarySearch- List使用二进制搜索算法搜索有序元素。
    *   indexOfSubList- 返回一个List等于另一个子列表的第一个子列表的索引。
    *   lastIndexOfSubList- 返回一个List等于另一个子列表的最后一个子列表的索引。
    * */
}
