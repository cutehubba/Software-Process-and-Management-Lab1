package Set;

import java.util.List;
import java.util.Set;

/**
 * 应用一：排班管理系统
 *  时间轴上不能有空白
 *  一个标签只能出现在唯一一个时间段上
 *  同一时间段上只能有一个标签
 * 标签信息：L为员工Employee
 * Employee 应该包括 姓名 职务  手机号码
 *
 * 应用二：CPU进程管理系统
 *  时间轴上可以有空白
 *  一个标签可以出现在多个时间段上
 *  同一时间段上只能有一个标签
 * 标签信息：L为进程Process
 * Process 应该包括 进程 ID、进程名称、最短执行时间、最长执行时间
 *
 * 应用三：年级课表管理系统
 *   时间轴上可以有空白
 *    一个标签可以出现在多个时间段上
 *    同一时间段上可以有多个标签
 *  额外特征：时间段可以按周为单位重复
 * 标签信息：L为课程Course
 * Course 应该包括 课程 ID、课程名称、教师名字、地点
 * */
public interface IntervalSet<L> {
    /**
     * 创建一个空对象：empty()
     * @param <L>
     * @return ...
     */
    public static <L> IntervalSet<L> empty()
    {
        return new CommonIntervalSet<L>();
    }
    /**
     *  在当前对象中插入新的时间段和标签
     * @param start 时间段开始时间
     * @param end  时间段结束时间
     * @param label  时间段标签
     */
    public void insert(long start,long end,L label);
    /**
     * 获得当前对象中的标签集合：Set<L> labels()
     * @return  标签集合
     */
    public Set<L> labels();

    /**
     * 从当前对象中移除某个标签所关联的时间段：boolean remove(L
     label)
     * @param label
     * @return true or false(是否成功remove)
     */
    public boolean remove(L label);
    /**
     *  返回某个标签对应的时间段的开始时间
     *
     * @param label
     * @return 开始时间
     */
    public long start (L label);
    /**
     * 返回某个标签对应的时间段的结束时间
     * @param label
     * @return 结束时间
     */
    public long end(L label);

    public List<Interval<L>> getIntervals();

    public void sort();
}
