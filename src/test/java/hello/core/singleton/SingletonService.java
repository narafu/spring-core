package hello.core.singleton;

public class SingletonService {

    // 클래스 생성할 때 자기 자신 객체 생성
    private static final SingletonService instance = new SingletonService();

    // 외부에서 new 키워드로 새로 생성하는 것 방지 : private
    private SingletonService() {
    }

    // 외부에서는 이미 생성된 객체를 호출할 수만 있음 : public
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
