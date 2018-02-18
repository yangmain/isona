package com.spring4all.isona.autoconfig;

import com.spring4all.isona.utils.HttpUtils;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan("com.spring4all.isona.web")
public class CommonAutoConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
        return client;
    }

    @Bean
    public HttpUtils httpUtils(OkHttpClient okHttpClient) {
        return new HttpUtils(okHttpClient);
    }

    @Bean
    public IsonaProperties isonaProperties() {
        return new IsonaProperties();
    }

}
