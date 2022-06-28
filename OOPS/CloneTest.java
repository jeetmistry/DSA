import java.util.*;
import java.time.*;
public class CloneTest implements Cloneable {
    int id;
    String name = "";
    CloneTest(int id, String name){
        this.id = id;
        this.name = name;
    }
    public CloneTest clone() throws CloneNotSupportedException{
        return (CloneTest)super.clone();
    }
    public static void main(String[] args) {
        long start,end;
        long timeElapsed;
        start = System.nanoTime();
        CloneTest t = new CloneTest(1, "Jeet");
        end = System.nanoTime();
        timeElapsed = end-start;

        System.out.println(t.id+ "  " + t.name + "  "+ timeElapsed);

        try {
            start = System.nanoTime();
            CloneTest t1 = t.clone();
            end = System.nanoTime();
            timeElapsed = end-start;
            System.out.println(t1.id + "  " +t1.name+"  "+timeElapsed);
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        start = System.nanoTime();
        CloneTest t2 = new CloneTest(1, "Jeet");
        end = System.nanoTime();
        timeElapsed = end-start;

        System.out.println(t2.id+ "  " + t2.name + "  "+ timeElapsed);

    }
}
