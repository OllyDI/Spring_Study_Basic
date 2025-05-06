package Spring_Project.basic.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 이 객체는 getInstance를 통해서만 조회할 수 있음
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
