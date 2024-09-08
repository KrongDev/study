package com.study.design.patterns.creational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 추상 팩토리 패턴입니다.
 *
 * 인터페이스 혹은 추상클래스를 상속받은 자원들을
 * 상황에 맞춰 할당하여 사용하는 패턴입니다.
 */
public class AbstractFactory {

    public enum FactoryType {
        CIRCLE,
        TRIANGLE
    }

    public static abstract class Factory {
        private final FactoryType type;

        public Factory(FactoryType type) {
            this.type = type;
        }

        public String getFactoryType(){
            return "FactoryType:" + type.toString();
        }
    }

    public static class CircleFactory extends Factory {

        public CircleFactory() {
            super(FactoryType.CIRCLE);
        }
    }

    public static class TriangleFactory extends Factory {

        public TriangleFactory() {
            super(FactoryType.TRIANGLE);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Factory factory = null;

        String type = br.readLine();

        if(FactoryType.CIRCLE == FactoryType.valueOf(type)) {
            factory = new CircleFactory();
        } else if(FactoryType.TRIANGLE == FactoryType.valueOf(type)) {
            factory = new TriangleFactory();
        }

        if(factory == null) return;

        System.out.println(factory.getFactoryType());
    }
}
