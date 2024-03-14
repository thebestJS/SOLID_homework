// Bird 클래스는 새의 일반적인 특성을 가짐
class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    // 기본적인 새의 행동이나 속성 메소드들...
}

// Flyable 인터페이스는 날 수 있는 새의 행동을 정의
interface Flyable {
    void fly();
}

// Swimmable 인터페이스는 수영할 수 있는 새의 행동을 정의
interface Swimmable {
    void swim();
}

// Eagle 클래스는 Bird를 상속받고 Flyable 인터페이스를 구현
class Eagle extends Bird implements Flyable {
    public Eagle(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("독수리가 날아오릅니다!");
    }
}

// Penguin 클래스는 Bird를 상속받고 Swimmable 인터페이스를 구현
class Penguin extends Bird implements Swimmable {
    public Penguin(String name) {
        super(name);
    }

    public void swim() {
        System.out.println("펭귄이 수영합니다!");
    }
}

// 클라이언트 코드
public class BirdClient {
    public static void main(String[] args) {
        Eagle eagle = new Eagle("독수리");
        Penguin penguin = new Penguin("펭귄");

        eagle.fly();
        penguin.swim();
    }
}