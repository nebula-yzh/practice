package interview1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nebula
 * @date 2021/11/15 11:07
 * @description: TODO
 */
public class Test3 {
    private Lock mLock;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Test3 test3 = new Test3(lock);
        test3.outer();
    }
    public Test3(Lock mLock){
        this.mLock=mLock;
    }
    public void outer(){
        mLock.lock();
        try {
            System.out.println("获取第一次锁");
            inner();
            System.out.println("回到第一个函数");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            mLock.unlock();
        }

    }

    public void inner(){
        mLock.lock();
        try {
            System.out.println("获取第二次锁");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            mLock.unlock();
        }
    }
}
