package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();//자기 자신을 static 영역에 생성한다.

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("instance = " + instance);
    }

}
