import com.redis.RedisCacheApplication;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = RedisCacheApplication.class)
@Slf4j
public class RedisConfigTest {

    @Setter
    @Resource
    private RedisTemplate redisJsonTemplate;

    @Test
    public void connectionTest() {
        redisJsonTemplate.opsForValue().set("foo", "bar");
        log.info("Foo: " + redisJsonTemplate.opsForValue().get("foo"));
    }
}
