package Set;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public abstract class IntervalSetTest {
	
	public abstract <L> IntervalSet<L> emptyInstance();

	/**
	 * 测试L为String类型时，getIntervals函数能否正确执行
	 * 设置Intervals为正确结果，检查结果与Intervals是否一致
	 * */
    @Test 
    public void testGetIntervals()
    {
    	IntervalSet<String> interval = emptyInstance();
    	List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	assertEquals(interval.getIntervals(),Intervals);
    	Intervals.add(new Interval<String>(3,4,"b"));
    	interval.insert(3, 4, "b");
    	assertEquals(interval.getIntervals(),Intervals);
    }
    /**
	 * 测试L为String类型时，labels函数能否正确执行
	 * 设置labels为正确结果，检查结果与labels是否一致
	 * */
    @Test 
    public void testLabels()
    {
    	IntervalSet<String> interval = emptyInstance();
    	Set<String> labels = new HashSet<>();
    	interval.insert(1, 2, "a");
    	labels.add("a");
    	assertEquals(interval.labels(),labels);
    	interval.insert(3, 4, "b");
    	labels.add("b");
    	assertEquals(interval.labels(),labels);
    }
    
    /**
   	 * 测试L为String类型时，sort函数能否正确执行
   	 * 设置Intervals为正确结果，检查结果与Intervals是否一致
   	 * */
    @Test 
    public void testSort()
    {
    	IntervalSet<String> interval = emptyInstance();
    	List<Interval<String>> Intervals = new ArrayList<>();
    	interval.insert(1, 2, "a");
    	interval.insert(5, 6, "c");
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(1,2,"a"));
    	Intervals.add(new Interval<String>(3,4,"b"));
    	Intervals.add(new Interval<String>(5,6,"c"));
    	interval.sort();
    	assertEquals(Intervals,interval.getIntervals());
    }



}
