package 锁;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author https://github.com/wujiahui1023
 * @date 2020/10/15 15:06
 */
public class 自旋锁 {



    /**
     * https://mp.weixin.qq.com/s/pGiTO1T_vny0Jxv0gVEHhA
     * Java实现一个自旋锁
     *
     * 上段代码中，方法lock利用的CAS，当线程A获取锁的时候，成功获取不会进入while循环。
     * 如果此时线程A没有释放锁，当线程B来获取锁的时候，由于不满足CAS，就会进入whilei循环，不断判断是否满足CAS，
     * 直到线程A调用unlock释放。
     */
    public class SpinLock {

        private AtomicReference<Thread> cas = new AtomicReference<Thread>();

        public void lock() {
            Thread current = Thread.currentThread();
            // 利用CAS
            while (!cas.compareAndSet(null, current)) {
                // DO
            }
        }

        public void unlock() {
            Thread current = Thread.currentThread();
            cas.compareAndSet(current, null);
        }
    }
}
