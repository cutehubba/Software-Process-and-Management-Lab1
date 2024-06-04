package Set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CourseIntervalSetTest extends MultiIntervalSetTest{

    @Override
    public <L> IntervalSet<L> emptyInstance() {
        return new MultiIntervalSet<L>();
    }
    /**
     * 测试L为String类型时，getIntervals函数能否正确执行
     * 设置Intervals为正确结果，检查结果与Intervals是否一致
     * */
    @Test
    public void testInsert()
    {
        IntervalSet<String> interval = emptyInstance();
        List<Interval<String>> Intervals = new ArrayList<>();
        Intervals.add(new Interval<String>(1,2,"a"));
        interval.insert(1, 2, "a");
        assertEquals(interval.getIntervals(),Intervals);
        interval.insert(3, 4, "a");
        Intervals.add(new Interval<String>(3,4,"a"));
        assertEquals(interval.getIntervals(),Intervals);
        interval.insert(3, 4, "b");
        Intervals.add(new Interval<String>(3,4,"b"));
        assertEquals(interval.getIntervals(),Intervals);
    }
    /**
     * 测试L为String类型时，getIntervals函数能否正确执行
     * 设置Intervals为正确结果，检查结果与Intervals是否一致
     * */
    @Test
    public void testRemove()
    {
        MultiIntervalSet<String> interval = new MultiIntervalSet<String>();
        List<Interval<String>> Intervals = new ArrayList<>();
        Intervals.add(new Interval<String>(1,2,"a"));
        interval.insert(1, 2, "a");
        interval.insert(3, 4, "a");
        Intervals.add(new Interval<String>(3,4,"a"));
        interval.insert(3, 4, "b");
        Intervals.add(new Interval<String>(3,4,"b"));
        assertEquals(interval.getIntervals(),Intervals);
        interval.remove("a");
        Intervals.remove(1);
        Intervals.remove(0);
        assertEquals(interval.getIntervals(),Intervals);
    }
    /**
     * 测试L为String类型时，getIntervals函数能否正确执行
     * 设置Intervals为正确结果，检查结果与Intervals是否一致
     * */
    @Test
    public void testIntervals()
    {
        MultiIntervalSet<String> interval = new MultiIntervalSet<String>();
        List<Interval<String>> Intervals = new ArrayList<>();
        Intervals.add(new Interval<String>(1,2,"a"));
        Intervals.add(new Interval<String>(3,4,"a"));
        interval.insert(1, 2, "a");
        interval.insert(3, 4, "a");
        interval.insert(3, 4, "b");
        assertEquals(Intervals,interval.intervals("a").getIntervals());
    }

}