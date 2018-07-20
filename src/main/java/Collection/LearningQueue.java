package Collection;


import java.util.Queue;

/*
* Queue是在处理之前保存元素的集合。除了基本的Collection操作，Queue还提供额外的插入、删除和检查操作。接口如下：
* public interface Queue<E> extends Collection<E> {
*   E element();
*   boolean offer(E e);
*   E peek();
*   E poll();
*   E remove();
*}
* 每种Queue方法都有两种形式：
* （1）如果操作失败则抛出异常
* （2）如果操作失败，则另一种返回特殊值（null或者false，取决于操作）。
* 其中add(e)、remove()以及element()操作失败引发异常
*    offer(e)、poll()、peek()操作失败返回异常值
*    add和offer为插入操作
*    remove和poll为删除操作
*    element和peek操作为检查操作
* 队列通常（但不一定）以FIFO（先进先出）方式对元素进行排序。优先级队列除外，它们根据元素的值对元素进行排序。每个Queue实现都必须指定其排序属性。
* 无论使用什么顺序，队列的头部都是通过调用remove或删除的元素poll。在FIFO队列中，所有新元素都插入队列的尾部。其他类型的队列可能使用不同的放置规则。
* 队列实现通常不定义equals和hashCode方法的基于元素的版本，而是从对象继承基于身份的版本。
* */
public class LearningQueue<T>{

    /*
    * offer方法和add方法的区别仅仅在于有限队列中offer插入失败返回false，而add直接抛出异常，无限队列中从源码看offer和add无任何区别。
    * 在jdk10中，java.util包中的Queue的实现类全部是无限队列，而java.util.concurrent包中部分是有限队列
    * */
    public void addElement(Queue<T> queue,T t){
        queue.offer(t);
        queue.add(t);

    }
    /*
    * 该remove和poll方法都删除并返回队列的头部。确切地删除哪个元素是队列的排序策略的功能。remove和poll只有当队列为空在他们的行为方式有所不同。
    * 在这种情况下，remove抛出NoSuchElementException，poll返回null。
    * */
    public void removeElement(Queue<T> queue){
        queue.remove();
        queue.poll();
    }
    /*
    * 该element和peek方法返回但不移除队列的头部。如果队列为空，element抛出NoSuchElementException，而peek回报null。
    * 队列实现通常不允许插入null元素，LinkedList实现是一个例外。出于历史原因，它允许使用null元素，但您应该避免使用它，因为poll和peek方法将null用作特殊的返回值。
    * */
    public void peekElement(Queue<T> queue){
        queue.peek();
        queue.element();
    }

}
