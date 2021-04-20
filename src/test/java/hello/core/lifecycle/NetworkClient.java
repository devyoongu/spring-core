package hello.core.lifecycle;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출

    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url+" Meessage = "+message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    //의존관계 주입이 끝나면 호출해 주는 메서드
//    @Override
    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    //소멸전콜백
//    @Override
    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
