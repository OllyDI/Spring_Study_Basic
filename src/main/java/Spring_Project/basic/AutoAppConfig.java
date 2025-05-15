package Spring_Project.basic;

import Spring_Project.basic.member.MemberRepository;
import Spring_Project.basic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

// 현재 만들어놓은(테스트 or AppConfig) 컨피그레이션이랑 겹쳐서 필터를 통해 제외
// 컴포넌트스캔은 @Component 어노테이션이 붙은 클래스를 자동으로 스프링 빈에 등록해줌
// basePackages 를 통해 파일 탐색 시간을 줄여줌
// basePackageClasses 를 지정해주지 않으면 패키지 전체를 뒤져서 ComponentScan 이 붙은 클래스를 찾아 지정
// 또는 프로젝트 패키지 최상단에 ComponentScan 클래스를 생성
@ComponentScan(
        basePackages = "Spring_Project.basic",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


    // 아래는 수동으로 만든 빈, MemoryMemberRepository 자동으로 만든 빈
    // 수동 빈이 자동 빈을 오버라이딩해버림 -> 여러 설정들이 꼬이기 때문에 잡기 어려운 버그가 발생
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}