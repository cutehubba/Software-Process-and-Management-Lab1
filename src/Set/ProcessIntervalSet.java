package Set;

import java.util.Iterator;
import java.util.Set;
import App.Process;
public class ProcessIntervalSet extends MultiIntervalSet<Process>{
    @Override
    public IntervalSet<Process> intervals(Process label){return  super.intervals(label);}
    /**
     * 返回输出结果
     * @return string
     * */
    @Override
    public String toString(){
        Set<Process> processSet = this.labels();
        StringBuffer s = new StringBuffer();
        Iterator<Process> iterator = processSet.iterator();
        while (iterator.hasNext()){
            Process process = iterator.next();
            s.append(process.getID() + "  " + process.getName() + "  " + this.intervals(process) + "\n");
        }
        return s.toString();
    }
    /**
     * process允许空白
     * @return true
     * */
    @Override
    public boolean checkRep(){return true;}
}
