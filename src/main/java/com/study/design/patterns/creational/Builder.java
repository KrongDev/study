package com.study.design.patterns.creational;


/**
 * Builder 패턴입니다.
 *
 * 복잡한 필드들을 가지고 있는 클래스들을 생성할 때 보다 직관적으로 생성할 수 있다는 장점이 있습니다.
 * 단점으로는 lombok을 사용하지 않는다면 구현해야하는 코드량이 증가한다는 단점이 존재합니다.
 */
public class Builder {

    public static class TestNode {
        private String name;
        private int age;

        public TestNode(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("TestNode [name=%s, age=%s]", name, age);
        }

        public static TestNodeBuilder builder() {
            return new TestNodeBuilder();
        }
    }

    public static class TestNodeBuilder {

        private String name;
        private int age;

        public TestNodeBuilder() {

        }

        TestNodeBuilder name(String name) {
            this.name = name;
            return this;
        }

        TestNodeBuilder age(int age) {
            this.age = age;
            return this;
        }

        TestNode build() {
            return new TestNode(name, age);
        }
    }

    public static void main(String[] args) {
        TestNode testNode = TestNode.builder()
                .name("MyName")
                .age(20)
                .build();

        System.out.println(testNode);
    }

}
