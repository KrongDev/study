package com.study.java.object.code;

import java.util.HashSet;
import java.util.Set;

public class EqualsAndHash {

    public record TestObject (String name, int count) {

        @Override
        public boolean equals(Object o) {
            TestObject that = (TestObject) o;
            return this.name.equals(that.name);
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }
    }

    /**
     * Equals와 HashCode를 왜 같이 재정의 해야하는지를 나타내는 코드로,
     * 아래 결과를 실행해보면 set에는 하나의 값만 쌓이게 된다.
     *
     * 아래 코드는 결국 의도하지 않았으면 좋은 코드는 아니라고 생각한다.
     * 다만, Equals와 HashCode를 재정의하는 이유를 Set을 사용하면 직관적으로 코드만 보고 이해할 수 있을 것이라 생각하여 아래와 같이 작성하였다.
     */
    public static void main(String[] args) {
        TestObject test1 = new TestObject("test1", 0);
        TestObject test2 = new TestObject("test1", 1);

        Set<TestObject> set = new HashSet<>();
        set.add(test1);
        set.add(test2);

        System.out.println(set.size());
    }
}
