package Set;

import App.Course;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CourseIntervalSet extends MultiIntervalSet<Course> {
    @Override
    public IntervalSet<Course> intervals(Course label){return  super.intervals(label);}

    private String toTime(int t){
        Map<Integer,String> map = new HashMap<>();
        map.put(8,"8:00-9:45");
        map.put(10,"10:00-11:45");
        map.put(13,"13:45-15:30");
        map.put(15,"15:45-17:30");
        map.put(18,"18:30-20:15");
        map.put(20,"20:30-22:15");
        if(map.containsKey(t)){
            return map.get(t);
        }
        return "";
    }
    @Override
    public String toString(){
        Set<Course> courseSet = this.labels();
        StringBuffer s = new StringBuffer();
        Iterator<Course> iterator = courseSet.iterator();
        while (iterator.hasNext()){
            Course course = iterator.next();
            s.append("\n" + course.getCourseID() + "  " + course.getCourseName() + "  " + course.getTeacherName() + "  "
             + course.getPlace() + ": \n");

            IntervalSet<Course> intervalSet = this.intervals(course);
            Set<Course> labels = intervalSet.labels();
            Iterator<Course> iterator1 = labels.iterator();
            while(iterator1.hasNext()){
                Course course1 = iterator1.next();
                try {
                    s.append("周" + intervalSet.start(course1) + "  " + toTime((int) intervalSet.end(course1)) + "  ");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
    /**
     * 允许重叠和空白
     * @return true
     * */
    @Override
    public boolean checkRep(){return true;}
}
