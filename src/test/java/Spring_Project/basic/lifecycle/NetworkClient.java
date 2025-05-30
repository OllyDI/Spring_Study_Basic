package Spring_Project.basic.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 초기화 소멸 콜백 인터페이스 단점
// 1. 스프링 전용 인터페이스 의존
// 2. 초기화, 소멸 메서드 이름 변경 불가
// 3. 내가 코드를 고칠 수 없는 외부 라이브러리에 적용 불가
// 스프링 초창기에 나온 방법으로 거의 사용 안함!!
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호줄, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct  // 가장 권장하는 초기화 콜백 방법 -> 유일한 단점 외부 라이브러리에는 사용 불가
    public void init(){
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy     // 가장 권장하는 소멸 콜백 방법
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }

//    인터페이스를 이용한 방법
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }
}
