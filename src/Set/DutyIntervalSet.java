package Set;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import App.Employee;
/**
 * 代表一个值班表
 * */
public class DutyIntervalSet extends CommonIntervalSet<Employee>{
    /**
     * 按照值班表格式输出
     * @return 值班表
     * */
    @Override
    public String toString(){
        List<Interval<Employee>> intervals = new LinkedList<>();
        Iterator<Employee> iterator = this.labels().iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            Interval<Employee> employeeInterval = null;
            try {
                employeeInterval = new Interval<>(this.start(employee),this.end(employee),employee);
            }catch (Exception e){
                e.printStackTrace();
            }
            intervals.add(employeeInterval);
        }
        Collections.sort(intervals, (o1, o2) ->{return (int) (o1.getStart()-o2.getStart());});
            StringBuffer s = new StringBuffer();
            Iterator<Interval<Employee>> iterator1 = intervals.iterator();
            while (iterator1.hasNext()){
                Interval interval = iterator1.next();
                s.append(interval.toString());
            }
            return s.toString();
    }

}
