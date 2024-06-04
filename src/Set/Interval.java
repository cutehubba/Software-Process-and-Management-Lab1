package Set;

public class Interval<L> implements Comparable<Interval<L>>{
    private long start,end;
    @Override
    public int hashCode() {
        return 1;
    }
    /**
     * 重写equals方法用于对时间段进行排序
     * @return  相等时返回true 不等时返回false
     * */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        @SuppressWarnings("rawtypes")
        Interval other = (Interval) obj;
        if (end != other.end)
            return false;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (start != other.start)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Interval [start=" + start + ", end=" + end + ", label=" + label + "]";
    }
    private L label;
    public long getStart() {
        return start;
    }
    public void setStart(long start) {
        this.start = start;
    }
    public long getEnd() {
        return end;
    }
    public void setEnd(long end) {
        this.end = end;
    }
    public L getLabel() {
        return label;
    }
    public void setLabel(L label) {
        this.label = label;
    }
    public Interval(long start,long end,L label)
    {
        this.start = start;
        this.end = end;
        this.label = label;
    }
    public boolean Equal(Interval<?> a)
    {
        if(start!=a.start)
            return false;
        if(end  != a.end)
            return false;
        return true;
    }
    /**
     * 重写Comparable接口的compareTo方法
     * 用于对Interval之间进行比较大小的操作
     * */
    @Override
    public int compareTo(Interval<L> A) {
        return (int)start-(int)A.getStart();
    }
}
