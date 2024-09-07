package com.study.design.patterns.creational;

/**
 * 디자인 패턴 팩토리 메소드 패턴에 대한 예제입니다.
 *
 * 부모 요소들을 재정의 하여 각각의 자식 클래스들을 생성한다면 부모 메소드를 호출하여 따로 처리할 필요없이 해당 클래스에서 원하는 결과값을 유동적으로 얻을 수 있는 패턴이다.
 *
 * 장점: 부모를 잘 정의할시 아래 코드와 같이 각 자식 클래스와 기능의 결합이 많이 낮아진다 ( 행위는 부모에 정의 되어있고, 자식은 해당 정의를 구현한 것이기 때문 )
 * 단점: 아래와 같이 많은 자원을 요구하고, 정의를 명확하게 하지 않을 경우 많이 복잡해질 수 있다.
 */
public class FactoryMethod {
    public abstract static class Canvas {
        Button createButton() {
         return null;
        }

        void onClickButton() {
            Button button = createButton();
            button.onClick();
        }
    }

    public static class WindowCanvas extends Canvas {
        @Override
        public Button createButton() {
            return new WindowButton();
        }
    }

    public static class MacCanvas extends Canvas {
        @Override
        public Button createButton() {
            return new MacButton();
        }
    }

    public interface Button {
        void onClick();
    }

    public static class WindowButton implements Button {

        @Override
        public void onClick() {
            System.out.println("Window");
        }
    }

    public static class MacButton implements Button {

        @Override
        public void onClick() {
            System.out.println("Mac");
        }
    }

    public static void main(String[] args) {
        Canvas canvas = new MacCanvas();
        canvas.onClickButton();
    }
}
