package interview1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Nebula
 * @date 2021/12/9 22:57
 * @description: TODO
 */
public class Test5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        LinkedList linkedList = new LinkedList();


        for (int i=0;i<1000000;i++){
            list.add(i);

        }
        long s1 = System.currentTimeMillis();
        list.contains(900000);
        long s2 = System.currentTimeMillis();
        System.out.println("数组:"+(s2-s1));

        for (int i=0;i<1000000;i++){
            linkedList.add(i);

        }
        long s3 = System.currentTimeMillis();
        linkedList.contains(900000);
        long s4 = System.currentTimeMillis();
        System.out.println("链表:"+(s4-s3));
    }
}
