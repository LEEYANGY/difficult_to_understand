package xyz.leeyangy.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * 编写自己的RedisTemplate
 */
@Configuration
public class RedisConfig {

        @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
//        为了方便开发，一般直接使用String，Object
        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        配置连接工厂
        template.setConnectionFactory(redisConnectionFactory);
//        配置具体序列化方式
//        序列化配置
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        该方法已过期
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        以下两个是替换
//        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        om.activateDefaultTyping(om.getPolymorphicTypeValidator());
        jackson2JsonRedisSerializer.setObjectMapper(om);

//        String序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        key采用String序列化方式
        template.setKeySerializer(stringRedisSerializer);
//        hash key也采用String序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
//        value序列化采用json
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
//        hash的value采用json
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }

}
