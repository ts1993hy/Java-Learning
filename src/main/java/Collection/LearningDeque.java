package Collection;

import java.util.Deque;

/*
* Deque是双端队列。双端队列是元素的线性集合，支持在两端插入和删除元素。
* Deque接口是比堆栈和队列更丰富的抽象数据类型，因为它同时实现堆栈和队列。
* Deque接口定义了访问Deque实例两端元素的方法。提供了插入、删除和检查元素的方法。
* 预定义类如ArrayDeque和LinkedList实现了Deque接口。
* Deque接口可以用作后进先出堆栈和先出队列。
* */
public class LearningDeque<T> {

    /*
    * 1.插入
    * addFirst和offerFirst方法在Deque实例的开头插入元素。方法addLast和offerLast在Deque实例末尾插入元素。
    * 当Deque实例的容量受到限制时，首选方法是addFirst和addLast，因为如果队列已满，则offerFirst不会抛出异常。(此处官方文档有误)
    * */
    public void add(Deque<T> deque,T t){
        deque.addFirst(t);
        deque.offerFirst(t);
        deque.addLast(t);
        deque.offerLast(t);
    }

    /*
    * 2.删除
    * removeFirst和pollFirst方法从Deque实例开头删除元素。removeLast和pollLast方法从末尾删除元素。
    * 如果Deque为空，那么pollFirst和pollLast方法返回null，而如果Deque实例为空，则removeFirst和removeLast方法抛出异常。
    * */
    public void remove(Deque<T> deque){
        deque.removeFirst();
        deque.removeLast();
        deque.pollFirst();
        deque.pollLast();
    }
    /*
    * 3.检查
    * 方法getFirst和peekFirst检索Deque实例的第一个元素。这些方法不会从Deque实例中删除值。类似地，getLast和peekLast方法检索最后一个元素。
    * 如果deque实例为空，则getFirst和getLast方法抛出异常，而方法peekFirst和peekLast返回NULL。
    * */
    public void retrieve(Deque<T> deque){
        deque.getFirst();
        deque.peekFirst();
        deque.getLast();
        deque.peekLast();
    }

    /*
    * 除了插入，删除和检查Deque实例的这些基本方法之外，该Deque接口还具有一些更预定义的方法。
    * 其中之一是removeFirstOccurence，如果指定元素存在于Deque实例中，则此方法将删除指定元素的第一个出现。如果元素不存在，则Deque实例保持不变。
    * 另一种类似的方法是removeLastOccurence;
    * 此方法删除Deque实例中指定元素的最后一次出现。这些方法的返回类型是boolean，如果元素存在于Deque实例中，它们将返回true。
    * */
}
