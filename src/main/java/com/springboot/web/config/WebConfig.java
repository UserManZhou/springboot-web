package com.springboot.web.config;

import com.springboot.web.converter.CustomConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper pathHelper = new UrlPathHelper();
//        pathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(pathHelper);
//    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
//            @Override
//            public void configurePathMatch(PathMatchConfigurer configurer) {
//                UrlPathHelper urlPathHelper = new UrlPathHelper();
//                urlPathHelper.setRemoveSemicolonContent(false);
//                configurer.setUrlPathHelper(urlPathHelper);
//            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                // 自定义内容协商URL
                Map<String,MediaType> mediaTypeMap = new HashMap<>();
                mediaTypeMap.put("JSON",MediaType.APPLICATION_JSON);
                mediaTypeMap.put("XML", MediaType.APPLICATION_XML);
                mediaTypeMap.put("ZH", MediaType.parseMediaType("application/x-zh"));
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);
                parameterContentNegotiationStrategy.setParameterName("fff");
                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
//                configurer.mediaType("JSON", MediaType.APPLICATION_JSON);
//                configurer.mediaType("xml", MediaType.APPLICATION_XML);
//                configurer.mediaType("zh", MediaType.parseMediaType("application/x-zh"));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                // 添加自定义内容协商转换
                converters.add(new CustomConverter());
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            }
        };
        return webMvcConfigurer;
    }
}
