package com.test.first.config.redisconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by liuning on 2017/9/21.
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class HttpSessionConfig {
    /**
     * `@EnableRedisHttpSession` 这个注解创建了一个名为 springSessionRepositoryFilter
     * 的 bean，负责替换 httpSession,同由 redis 提供缓存支持。
     * 为了做到全部替换，我们要确保Servlet容器(Tomcat)对于某个请求都使用这个Filter,这个由SpringBoot负责。
     *
     * `maxInactiveIntervalInSeconds`:设置Session失效时间
     * 使用Redis Session之后，原Boot的server.session.timeout属性不再生效
     */
}
