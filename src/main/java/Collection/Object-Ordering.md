# 一、对象排序
>一个List对象l可以进行如下排序。
```$Java
    Collections.sort(l);
```
如果列表由`String`组成，它将按字母顺序排序。如果它包含`Date`元素，它将按时间顺序排序。这是如何发生的呢?因为`String`和`Date`都实现了`Comparable`接口。类似的实现为类提供了一个自然的排序，允许自动排序该类的对象。下表总结了实现`Comparable`接口的一些重要的Java平台类。

类型 | 排序方式
------------| -----------
Byte | 有符号数值
Character | 无符号数值 
Long | 有符号数值
Integer	| 有符号数值
Short | 有符号数值
Double | 有符号数值
Float | 有符号数值
BigInteger | 有符号数值
BigDecimal | 有符号数值
Boolean | Boolean.FALSE < Boolean.TRUE  
File | 依赖于系统的文件名的字典序
String | 字典  
Date | 按时间顺序排列  
CollationKey | 特定的字典序
如果您试图对没实现Comparable接口的列表进行排序，Collections.sort(list)将抛出ClassCastException异常。如果您试图对一个不能使用comparator进行比较的列表进行排序，Collections.sort(list, comparator)将抛出ClassCastException异常。可以相互比较的元素称为相互可比性。虽然不同类型的元素可以相互比较，但是这里列出的类都不允许进行类间比较。
# 二、实现你自己的Comparable接口
>Comparable接口实现方法
```Java
public interface Comparable<T> {
    public int compareTo(T o);
}
```
该compareTo方法将接收对象与指定对象进行比较，并根据接收对象是否小于（返回负整数），等于（返回0）或大于（返回正整数）指定对象。如果指定的对象无法与接收对象进行比较，则该方法抛出一个ClassCastException。
# 三、Comparators接口
>如果您想按照自然顺序排序某些对象，该怎么办？或者，如果要对某些未实现`Comparable`接口的对象进行排序，该怎么办？你需要一个实现Comparator接口的封装排序的对象。与Comparable接口一样，Comparator接口由单个方法组成。
```Java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```
该compare方法比较其两个参数，返回负整数，0或正整数，具体取决于第一个参数是小于，等于还是大于第二个参数。如果其中任何一个参数没实现Comparator接口，则该compare方法抛出一个ClassCastException异常。  
使用compare可能会出现这样一个问题，
```Java
public class Sort{ 
    static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.hireDate().compareTo(e1.hireDate());
            }
    };
}
```
上面的代码进行排序是没有问题的，使用`Collections.sort()`方法进行排序后是升序的，但是如果你想改成降序，最好改为`e1.hireDate().compareTo(e2.hireDate())`而不是`-e2.hireDate().compareTo(e1.hireDate())`，因为一旦compareTo的返回值为`Integer.MIN_VALUE`，结果就不会是你期望的那样，因为`-Integer.MIN_VALUE == Integer.MIN_VALUE`。  
该比较器可以很好地对列表进行排序，但是它有一个缺点:它不能用于已排序的集合(例如TreeSet)，因为它生成的排序与equals不兼容。这意味着该比较器可能把equals方法认为不相等的对象判断为相等。比如equals方法按照用户的ID进行排序，而compare方法按照用户年龄排序，一旦用户的年龄重复，那么TreeSet是不会存储相同元素的，我们的集合元素就出现了缺失。  
要解决这个问题，只需调整Comparator，使其产生与equals兼容的排序。换句话说，对它进行微调，使用compare时看到的唯一相等的元素是那些使用equals时看到的相等的元素。这样做的方法是进行两次比较，保证equals方法不相等时compare方法也不相等。  
还有就是compareTo方法尽量避免这样写`return e1.number() - e2.number();`，因为一旦`e1.number()`是一个大的正整数，而`e2.number()`是一个大的负整数，它们的差可能就会溢出，从而导致结果是一个负整数，这不是我们想要的结果。