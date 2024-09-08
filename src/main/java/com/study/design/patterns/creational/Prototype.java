package com.study.design.patterns.creational;

public class Prototype {

    public interface PrototypeSample<T> {
        T clone();
    }
    public record PrototypeTestNode(
            String name,
            int age
    ) implements PrototypeSample<PrototypeTestNode> {

        @Override
        public PrototypeTestNode clone() {
            return new PrototypeTestNode(
                    this.name,
                    this.age
            );
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PrototypeTestNode testNode = (PrototypeTestNode) o;
            return name.equals(((PrototypeTestNode) o).name) && age == testNode.age;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age;
            return result;
        }
    }

    public static void main(String[] args) {
        PrototypeTestNode test1 = new PrototypeTestNode("test1", 0);
        PrototypeTestNode test2 = test1.clone();

        System.out.println(test1.equals(test2));
        System.out.println(test1 == test2);
    }
}
