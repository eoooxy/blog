import com.doliao.ApplicationConfig;
import com.doliao.vo.FileVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * author： xueyuan
 * date  ： 2017-08-01 下午2:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
@WebAppConfiguration
public class RedisTest {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        List<FileVo> fileVos = new ArrayList<>();
        FileVo fileVo = new FileVo();
        fileVo.setFiletime("123");
        fileVo.setNum(5);
        fileVos.add(fileVo);
        fileVos.add(fileVo);
        fileVos.add(fileVo);
        fileVos.add(fileVo);
        stringRedisTemplate.opsForValue().set("name", fileVos.toString());
//        List<FileVo> f = stringRedisTemplate.opsForValue().get("name");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
    }


    @Test
    public void test2() {
        System.out.println("222");
    }

}
