package Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class APITest extends MultiIntervalSetTest{
    @Override
    public <L> IntervalSet<L> emptyInstance() {
        return new MultiIntervalSet<L>();
    }
    @Test
    public void testSimilarity(){
        MultiIntervalSet<String> a = new MultiIntervalSet<String>();
        MultiIntervalSet<String> b = new MultiIntervalSet<String>();
        a.insert(0,5,"A");
        a.insert(20,25,"A");
        a.insert(10,20,"B");
        a.insert(25,30,"B");
        b.insert(20,25,"A");
        b.insert(10,20,"B");
        b.insert(0,5,"C");
        API<String> api = new API<String>();
        assertEquals(15/35,api.Similarity(a,b),0);
    }
    @Test
    public void calcConflictTimeRatioTest(){
        MultiIntervalSet<String> a = new MultiIntervalSet<String>();
        a.insert(0,5,"A");
        a.insert(10,20,"A");
        a.insert(5,15,"B");
        API<String> api = new API<String>();
        assertEquals(0.25,api.calcConflictTimeRatio(a),0);
    }
    @Test
    public void calcFreeTimeRatioTest(){
        MultiIntervalSet<String> a = new MultiIntervalSet<String>();
        a.insert(0,5,"A");
        a.insert(15,20,"A");
        a.insert(25,30,"B");
        a.insert(35,40,"B");
        a.insert(45,50,"C");
        API<String> api = new API<String>();
        assertEquals(0.5,api.calcFreeTimeRatio(a),0);
    }
}