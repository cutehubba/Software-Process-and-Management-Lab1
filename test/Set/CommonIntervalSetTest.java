package Set;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CommonIntervalSetTest extends IntervalSetTest{

	@Override
	public <L> IntervalSet<L> emptyInstance() {
		return new CommonIntervalSet<L>();
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
	public void testStart()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(3,4,"b"));
    	assertEquals(1,interval.start("a"));
    	assertEquals(3,interval.start("b"));
	}
	
	
	/**
	 * 测试L为String类型时，getIntervals函数能否正确执行
	 * 设置Intervals为正确结果，检查结果与Intervals是否一致
	 * */
	@Test
	public void testEnd()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "b");
    	Intervals.add(new Interval<String>(3,4,"b"));
    	assertEquals(2,interval.end("a"));
    	assertEquals(4,interval.end("b"));
	}
	
	/**
	 * 测试L为String类型时，getIntervals函数能否正确执行
	 * 设置Intervals为正确结果，检查结果与Intervals是否一致
	 * */
	@Test 
	public void testRemove()
	{
		IntervalSet<String> interval = emptyInstance();
		List<Interval<String>> Intervals = new ArrayList<>();
    	Intervals.add(new Interval<String>(1,2,"a"));
    	Intervals.add(new Interval<String>(3,4,"b"));
    	Intervals.add(new Interval<String>(5,6,"c"));
    	interval.insert(1, 2, "a");
    	interval.insert(3, 4, "b");
    	interval.insert(5, 6, "c");
    	interval.remove("b");
    	Intervals.remove(1);
    	assertEquals(interval.getIntervals(),Intervals);
    	interval.remove("a");
    	Intervals.remove(0);
    	assertEquals(interval.getIntervals(),Intervals);
	}
}
