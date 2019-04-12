package me.hellozin.demospringmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /* Spring boot 에서는 굳이 WebConfig에 Formatter 추가 할 필요 없다.
     * Formatter 를 Bean으로 등록 해 두면 자동으로 추가 해 준다. */
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter(new PersonFormatter());
//        /* registry.addConverter(); 조금 더 generic 한 경우 */
//    }

    /* Interceptor 추가 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor())
                .addPathPatterns("/hello")
                .order(-1)
        ;
    }

    /* Resource Handler 추가 */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/sample/**")
                .addResourceLocations("classpath:/sample/")
                .setCacheControl(CacheControl.maxAge(3, TimeUnit.MINUTES))
        ;
    }
}
