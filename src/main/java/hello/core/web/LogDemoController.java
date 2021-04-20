package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myloggerProvider;
    // 1.MyLogger는 request 스코프이기 때문에 실제 request가 일어나야만 생성되서 bean이 없는 상태
    // 1-1실제 고객 요청 단계로 지연 시켜야 한다.
    // 1-2MyLogger를 주임받는 것이 아니라 MyLogger를 찾을 수 있는(dependency lookup할 수 있는) provider를 주입 받을 수 있다.
    private final MyLogger myLogger;
    //

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException{

        //        MyLogger myLogger = myloggerProvider.getObject();
        String requestUrl = request.getRequestURL().toString();
        myLogger.setRequestURL(requestUrl);

        myLogger.log("controller test");
        Thread.sleep(1000); //요청이 섞여도 구분할 수 있고, 요청이 많아도 request에 따라 스프링 빈을 할당해 준다.
        logDemoService.logic("testID");
        return  "OK";
    }
}
