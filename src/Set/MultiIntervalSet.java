package Set;

import java.util.*;

public class MultiIntervalSet<L> implements IntervalSet<L> {

    private List<Interval<L>> Intervals = new ArrayList<>();


    public MultiIntervalSet() {}

    /**
     * intervals的初始化方法
     * */
    public MultiIntervalSet(IntervalSet<L> initial)
    {
        Intervals.addAll(initial.getIntervals());
    }

    /**
     * intervals的get方法
     * @return 时间段集合
     * */
    public List<Interval<L>> getIntervals() {
        return Intervals;
    }


    /**
     * 如果是排班系统，那么需要检查是否已经存在这个标签，存在则不能再添加。
     * 如果是进程或者课表，标签存在也可以添加。
     *
     * 如果是排班系统或者进程，时间不能有重叠。
     * 如果课表，时间可以重叠。
     * @param start 时间段开始时间
     * @param end 时间段结束时间
     * @param label 标签
     * */
    @Override
    public void insert(long start, long end, L label) {Intervals.add(new Interval<L>(start,end,label));}
    /**
     * @return 所有标签的集合
     * */
    @Override
    public Set<L> labels() {
        Set<L> labels = new HashSet<>();

        int sz = Intervals.size();
        for(int i=0; i<sz; i++)
            labels.add(Intervals.get(i).getLabel());
        return labels;
    }

    /**
     * 从当前对象中移除某个标签所关联的所有时间段
     * @return 移除成功，返回true，标签不存在，返回false
     * */
    @Override
    public boolean remove(L label) {
        Iterator<Interval<L>> it = Intervals.iterator();
        boolean sign = false;
        while(it.hasNext())
        {
            Interval<L> v = it.next();
            if(v.getLabel().equals(label))
            {
                sign = true;
                it.remove();
            }
        }
        return sign;
    }

    /**
     * 方法不符合实际，不用实现
     */
    @Override
    public long start(L label) {return 0;}
    /**
     * 方法不符合实际，不用实现
     */
    @Override
    public long end(L label) {return 0;}
    /**
     * 将时间段从小到大排序，返回同一个标签对应的所有时间段
     * @param label 某个标签
     * @return 标签对应的所有时间段
     * */
    public IntervalSet<L> intervals(L label)
    {
        Iterator<Interval<L>> it = Intervals.iterator();
        IntervalSet<L> intervals = new MultiIntervalSet<L>();
        while(it.hasNext())
        {
            Interval<L> v = it.next();
            if(v.getLabel().equals(label))
                intervals.insert(v.getStart(), v.getEnd(), label);
        }
        intervals.sort();
        return intervals;
    }
    /**
     * 返回结果
     * @return 某对象的一个或多个时间段
     */
    @Override
    public String toString(){
        Set<L> set = this.labels();
        StringBuffer s = new StringBuffer();
        Iterator<L> iterator = set.iterator();
        while (iterator.hasNext()){
            L l = iterator.next();
            IntervalSet<L> interval = this.intervals(l);
            s.append(l + "{");
            try {
                s.append(interval.toString());
            }catch (Exception e){
                e.printStackTrace();
            }
            s.append("}");
        }
        return s.toString();
    }
    /**
     * 对时间段集合中元素按照开始时间从小到大排序
     * */
    @Override
    public void sort()
    {
        Collections.sort(Intervals);
    }
/**
 * “有无空白”的约束条件
 * 是否允许不同的Interval之间又重叠
 * 是否包含周期性时间段
 * 用checkRep()检验
 * @return true or false
 */
public boolean checkRep(){return false;}
}
