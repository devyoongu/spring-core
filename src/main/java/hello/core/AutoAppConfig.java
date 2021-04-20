package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackages = "hello.core",//  이렇게 따로 패키지명을 기재하지 않고  AutoAppConfig 파일을 루트에 설정 파일을 두는것이 좋다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))
public class AutoAppConfig {

}
