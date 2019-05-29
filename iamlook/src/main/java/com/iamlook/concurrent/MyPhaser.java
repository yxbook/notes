package com.iamlook.concurrent;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

    @Override
    //改写onAdvance方法
    public boolean onAdvance(int phase, int registeredParties) {
        //判断当前的Phaser是否终止
        if (!isTerminated()) {
            // 分成三个阶段，在不同的阶段(周期)，执行不同的屏障事件
            if (phase == 0) {
                // ....
                System.out.println("第一阶段：所有参赛者都到达了起跑点！");
                System.out.println("PR测试测试");
            } else if (phase == 1) {
                // ....
                System.out.println("第二阶段：所有参赛者都已经就位，并准备好！比赛正式开始");
            } else if (phase == 2) {
                // ....
                System.out.println("第三阶段：所有参赛者都到达终点，比赛结束！！");
            }
        }
        return super.onAdvance(phase, registeredParties);
    }
}