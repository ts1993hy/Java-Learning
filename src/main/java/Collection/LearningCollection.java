package Collection;

import java.util.*;
import java.util.stream.Collectors;

/*
* Collection接口批量操作
*   批量操作对整个操作执行操作Collection。您可以使用基本操作来实现这些简写操作，在大多数情况下，这种实现效率较低。以下是批量操作：
*   containsAll- 如果目标Collection包含指定的所有元素，则返回Collection。
*   addAll- 将指定的所有元素添加Collection到目标中Collection。
*   removeAll- 从目标中移除Collection指定中也包含的所有元素Collection。
*   retainAll- 从目标中移除Collection所有不包含在指定内容中的元素Collection。也就是说，它仅保留目标Collection中也包含在指定对象中的那些元素Collection。
*   clear- 从中删除所有元素Collection。
*   如果在执行操作的过程中修改了目标集合，那么addAll、removeAll和retainAll方法都会返回true。
*   作为一个简单的批量操作的例子，请考虑下面的方式，它可以从集合c中删除指定元素的所有实例。
*       c.removeAll(Collections.singleton(e));
*   更具体地说，假设您希望从集合中删除所有空元素。
*       c.removeAll(Collections.singleton(null));
*   singleton，它是一个静态工厂方法，返回一个仅包含指定元素的不可变集。
*   集合接口数组操作
*   toArray方法作为集合和在输入上使用数组的旧api之间的桥梁。数组操作允许将集合的内容转换为数组。没有参数的简单表单创建一个新的对象数组。更复杂的表单允许调用者提供数组或选择输出数组的运行时类型。
*   例如，假设c是一个集合。下面的代码片段将c的内容转储到新分配的对象数组中，该数组的长度与c中的元素数量相同。
*       Object[] a = c.toArray();
*   假设已知c只包含字符串(可能是因为c的类型为集合)。下面的代码片段将c的内容转储到一个新分配的字符串数组中，该字符串的长度与c中的元素数量相同。
*   String[] a = c.toArray(new String[0]);
* */

public class LearningCollection<T>{

    /*
    * 有三种方法来遍历集合：(1)使用聚合操作(2)for-each(3)通过使用Iterator。
    * */
    public void iterator(Collection<T> collection){
        /*
        * 第一种 聚合操作
        *   在JDK 8和更高版本中，迭代集合的首选方法是获取流并对其执行聚合操作。聚合操作通常与lambda表达式结合使用，使编程更具表现力，使用更少的代码行。
        *   以下代码按顺序遍历一组形状并打印出红色对象：
        * myShapesCollection.stream().filter(e -> e.getColor() == Color.RED).forEach(e -> System.out.println(e.getName()));
        *   同样可以轻松请求并行流，如果集合足够大，并且计算机具有足够的核心，则可能会有意义：
        * myShapesCollection.parallelStream().filter(e -> e.getColor() == Color.RED).forEach(e -> System.out.println(e.getName()));
        *   使用此API采集数据的方法有很多种。例如，您可能希望将a的元素转换Collection为String对象，然后将它们连接起来，用逗号分隔：
        * String joined = elements.stream().map(Object::toString).collect(Collectors.joining(","));
        *   或者总计所有员工的薪水：
        * int total = employees.stream().collect(Collectors.summingInt(Employee::getSalary)));
        * */
        String all = collection.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(all);
        /*
        * 第二种 for-each
        * 该for-each构造允许您使用for循环简洁地遍历集合或数组。
        * */
        for (T t:collection) {
            System.out.println(t.toString());
        }
        /*
        * 第三种 Iterator
        * Iterator是一个对象，使您可以遍历集合并有选择地从集合中删除元素。你Iterator通过调用它的iterator方法来获得一个集合。以下是Iterator接口。
        *   public interface Iterator<E> {
        *       boolean hasNext();
        *       E next();
        *       void remove(); //optional
        *   }
        * 如果迭代有多个元素，该hasNext方法返回true，next方法返回迭代中的下一个元素。
        * 该remove方法删除next返回的最后一个元素。该remove方法每次调用只能调用一次，如果违反此规则，则抛出异常。
        * 注意,Iterator删除是在迭代期间修改集合的唯一安全方法。
        * */
        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
    /*
    * 所有通用集合实现都有一个带Collection参数的构造函数。
    * 该构造函数（称为转换构造函数）初始化新集合以包含指定集合中的所有元素，无论给定集合的子接口或实现类型如何。换句话说，它允许你转换集合的类型。
    * 假设，你有一个Collection<String> c，可能是List或是Set，或另一种Collection。
    * 下面创建了一个新的ArrayList（List接口的实现），最初包含了所有的元素c。
     * */
    public List<T> getCollection(Collection<T> collection){
        return new ArrayList<>(collection);
    }

}
