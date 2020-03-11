package com.smh.Test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/3/2 20:41
 */
public class TestRedis {
    @Test
    public void test(){
        Jedis jedis = new Jedis("106.54.43.61",6379);
        jedis.auth("smh5630267");
        System.out.println(jedis.ping());
        jedis.hget
    }
}
