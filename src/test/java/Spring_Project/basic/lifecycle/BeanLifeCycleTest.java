package Spring_Project.basic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        // ac.close 를 사용하기 위해서는 AnnotationConfigApplicationContext 형태로 객체 생성 또는 ConfigurableApplicationContext 를 사용
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        // 메서드를 이용한 초기화, 소멸 콜백 호출
        // 설정 정보를 사용 -> 코드를 고칠 수 없는 외부 라이브러리에도 적용 가능
        // destroyMethod 기본값으로 추론이 등록되어 있는데 close or shutdown 이라는 메서드를 자동으로 소멸 콜백으로 호출해줌
        // @Bean(initMethod = "init", destroyMethod = "close")
        // 이 방법도 좋으나 대부분 어노테이션을 이용함

        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello");
            return networkClient;
        }
    }
}
