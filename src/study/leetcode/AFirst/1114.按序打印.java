package study.leetcode.AFirst;
/*
 * @lc app=leetcode.cn id=1114 lang=java
 *
 * [1114] 按序打印
 */

// @lc code=start
class Foo {

    private final Object object = new Object();
    private volatile int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) {
                object.wait();
            }
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) {
                object.wait();
            }
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) {
                object.wait();
            }
        }
        printThird.run();
    }
}
// @lc code=end
