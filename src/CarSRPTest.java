//SRP 예제
// 자동차의 주행 기능을 담당하는 클래스
class Car {
    private Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    // 자동차를 주행하는 메소드
    void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("자동차가 주행을 시작합니다.");
        }
    }

    // 자동차의 엔진을 멈추는 메소드
    void stop() {
        if (engine != null) {
            engine.stop();
            System.out.println("자동차가 멈춥니다.");
        }
    }
}

// 엔진의 기능을 담당하는 클래스
class Engine {
    void start() {
        // 엔진을 시작하는 로직
        System.out.println("엔진이 시작됩니다.");
    }

    void stop() {
        // 엔진을 정지하는 로직
        System.out.println("엔진이 정지됩니다.");
    }
}

// 예시 사용
public class CarSRPTest {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);

        car.drive(); // 자동차 주행 시작
        car.stop();  // 자동차 정지
    }
}
