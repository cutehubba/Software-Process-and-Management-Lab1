package Set;

import java.util.*;

public class CommonIntervalSet<L> implements IntervalSet<L> {

    private List<Interval<L>> Intervals = new ArrayList<>();

    /**
     * intervals的get方法
     * @return 时间段的List集合
     * */
    public List<Interval<L>> getIntervals() {
        return Intervals;
    }

    /**
     * intervals的set方法
     * @return 时间段的List集合
     * */
    public void setIntervals(List<Interval<L>> Intervals) {
        this.Intervals = Intervals;
    }

    /**
     * 如果是排班系统，那么需要检查是否已经存在这个标签，存在则不能再添加。
     * 如果是进程或者课表，标签存在也可以添加。
     * 如果是排班系统或者进程，时间不能有重叠。
     * 如果课表，时间可以重叠。
     * @param start 时间段开始时间
     * @param end 时间段结束时间
     * @param label 时间段标签
     * */
    @Override
    public void insert(long start, long end, L label) {
        int sz = Intervals.size();
        Interval<L> Interval = new Interval<L>(start,end,label);
        for(int i=0; i<sz; ++i)
            if(Interval.getLabel().equals(Intervals.get(i).getLabel())) {
                System.out.println("同一对象对应多个时间段");
                return ;
            }
        Intervals.add(Interval);
    }

    /**
     * @return  所有标签对应的集合
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
     * @return 标签存在，移除成功，返回true，标签不存在，返回false
     * */
    @Override
    public boolean remove(L label) {
        Iterator<Interval<L>> it = Intervals.iterator();
        while(it.hasNext())
        {
            Interval<L> v =it.next();
            if(v.getLabel().equals(label)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * @param label  时间段的标签
     * @return 返回某个标签所对应的开始时间
     * */
    @Override
    public long start(L label) {
        long start = -1;
        int sz = Intervals.size();
        for(int i=0; i<sz; ++i)
            if(Intervals.get(i).getLabel().equals(label))
                start = Intervals.get(i).getStart();
        return start;
    }

    /**
     * @param label  时间段的标签
     * @return 返回某个标签所对应的结束时间
     * */
    @Override
    public long end(L label) {
        long end = -1;
        int sz = Intervals.size();
        for(int i=0; i<sz; ++i)
            if(Intervals.get(i).getLabel().equals(label))
                end = Intervals.get(i).getEnd();
        return end;
    }

    /**
     * toString方法
     * */
    @Override
    public String toString()
    {
        Set<L> set = this.labels();
        StringBuffer s = new StringBuffer();
        Iterator<L> iterator = set.iterator();
        while (iterator.hasNext()){
            try {
                L l = iterator.next();
                s.append("Interval [start=" + this.start(l) + ", end=" + this.end(l) + ", label=" + l + "]");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return s.toString();
    }
    /**
     * 对Intervals集合进行排序
     * */
    @Override
    public void sort()
    {
        Collections.sort(Intervals);
    }
    /**
     * "有无空白约束定义
     * 是否允许不同的interval之间有重叠
     * 是都包含周期性的时间段
     * 出来并在checkReo()中检查】
     * @return true or false
     * "*/
    public boolean checkRep(){return false;}
}
