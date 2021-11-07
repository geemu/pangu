package com.github.geemu.pangu.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * com.github.geemu.pangu.backend
 * @author 陈方明  cfmmail@sina.com
 * @since 2021-11-07 16:38
 */
public class TestMain {

    // 账号数
    private static final Long DATA_SIZE = 10000L;
    // 最大可用的CPU核数
    public static final int AVAILABLE_CPU_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        // 初始化待处理数据
        List<Long> accountList = new ArrayList<>();
        for (long i = 0; i < DATA_SIZE; i++) {
            accountList.add(i);
        }
        List<List<Long>> groupedAccountList = averageAssign(accountList, 100);
        System.out.println(groupedAccountList);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    //准 备完毕……运动员都阻塞在这，等待号令
                    countDownLatch.await();
                    String partner = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(partner + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(2000);// 裁判准备发令
        countDownLatch.countDown();// 发令枪：执行发令
    }

    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> response = new ArrayList<>();
        int remainder = source.size() % n;  // 先计算出余数
        int number = source.size() / n;  // 然后是商
        int offset = 0;// 偏移量
        for (int i = 0; i < n; i++) {
            List<T> value;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            response.add(value);
        }
        return response;
    }

}
