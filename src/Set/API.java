package Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 计算相似度
 */
public class API<L> extends MultiIntervalSet<L>{
    public double Similarity(MultiIntervalSet<L> s1,MultiIntervalSet<L> s2) {
        //重复总长
        long sum = 0;
        //刻度标的最小开始
        long start = Long.MAX_VALUE;
        //刻度表的最大结束
        long end = 0;
        List<Interval<L>> list1 = s1.getIntervals();
        List<Interval<L>> list2 = s2.getIntervals();
        for(Interval<L> l1:list1){
            for(Interval<L> l2:list2){
                /**
                 * 计算两者最早的开始和最晚的结束
                 * */
                if(start > l1.getStart() || start > l2.getStart()){
                    start = (l1.getStart() > l2.getStart()) ? l2.getStart() : l1.getStart();
                }
                if(end < l1.getEnd() || end < l2.getEnd()){
                    end = (l1.getEnd() > l2.getEnd()) ? l1.getEnd() : l2.getEnd();
                }
                /**
                 * 该遍历为嵌套for循环
                 * 两个for分别为两个时间轴
                 * 每次遍历第二个for时间段时，当标签相同的时候，只有这时候可能发生重叠
                 * 此时比较两者开始时间和结束时间
                 * 若重叠则计算长度并且将长度记录到totalLength
                 * */
                if(l1.getLabel().equals(l2.getLabel())){
                    if(l1.getStart() >= l2.getStart()){
                        if(l1.getStart() < l2.getEnd()){
                            sum += l2.getEnd() - l1.getStart();
                        }
                    }
                    else{
                        if(l1.getEnd() > l2.getStart()){
                            sum +=l1.getEnd() - l2.getStart();
                        }
                    }
                }
            }
        }
    return sum/(end - start);
    }
    /**
     * 计算时间冲突比例
     * */
    public double calcConflictTimeRatio(MultiIntervalSet<L> set){
        //刻度标的最小开始
        long start = Long.MAX_VALUE;
        //刻度表的最大结束
        long end = 0;
        //冲突时间总长
        double sum = 0;
        Set<L> labels = new HashSet<>();
        List<Interval<L>> list = set.getIntervals();
        for(Interval<L> l:list){
            /**
             * 记录最小开始与最大结束
             * */
            if(start > l.getStart())
                start = l.getStart();
            if(end < l.getEnd())
                end = l.getEnd();
            /**
             * 只有标签不同时进出才可能冲突
             * 当标签不同时，重新循环时间段集合
             * 将其标签不同时，时间段的重叠时间长度计算出来并且加入到sum
             * */
            if(!labels.contains(l.getLabel()) && !labels.isEmpty()){
                for(Interval<L> lInterval:list){
                    if(!lInterval.getLabel().equals(l.getLabel())){
                        if(lInterval.getStart() <= l.getStart() && lInterval.getEnd() > l.getStart())
                            sum += (lInterval.getEnd() > l.getEnd()) ? l.getEnd() - l.getStart() :
                                    lInterval.getEnd() - l.getStart();
                        else if(lInterval.getStart() > l.getStart() && lInterval.getStart() < l.getEnd())
                            sum += (lInterval.getEnd() < l.getEnd()) ? lInterval.getEnd() - lInterval.getStart() :
                                    l.getEnd() - lInterval.getStart();
                    }
                }
            }
            labels.add(l.getLabel());
        }
        return sum / (end - start);
    }

    /**
     * 计算时间空闲比例
     */
    public double calcFreeTimeRatio(MultiIntervalSet<L> set){
        //刻度标的最小开始
        long start = Long.MAX_VALUE;
        //刻度表的最大结束
        long end = 0;
        //非空闲时间总长
        double sum = 0;
        List<Interval<L>> list = set.getIntervals();
        for(Interval<L> l:list){
            /**
             * 记录最小开始与最大结束
             * */
            if(start > l.getStart())
                start = l.getStart();
            if(end < l.getEnd())
                end = l.getEnd();
            //记录非空闲时间总长
            sum += l.getEnd() - l.getStart();
        }
        return (end - start- sum) / (end - start);
    }
}
