package com.study.design.patterns.creational;


/**
 * 가장 기본이되는 Singleton pattern 입니다.
 *
 * 보통 데이터베이스를 접근하는 클래스를 싱글턴으로 생성하여 관리합니다.
 */
public class Singleton {
    public static class SingletonSampleNode {
        private static SingletonSampleNode singletonSampleNode;

        private SingletonSampleNode() { }

        public static SingletonSampleNode getInstance() {
            if (singletonSampleNode == null) {
                singletonSampleNode = new SingletonSampleNode();
            }
            return singletonSampleNode;
        }
    }

    public static void main(String[] args) {
        SingletonSampleNode singletonSampleNode1 = SingletonSampleNode.getInstance();
        SingletonSampleNode singletonSampleNode2 = SingletonSampleNode.getInstance();

        System.out.println(singletonSampleNode1 == singletonSampleNode2);
    }
}
