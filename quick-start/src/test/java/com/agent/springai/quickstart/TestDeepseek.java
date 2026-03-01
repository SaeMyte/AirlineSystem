package com.agent.springai.quickstart;

import org.junit.jupiter.api.Test;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
public class TestDeepseek {
    @Test
    public void testDeepseek(@Autowired DeepSeekChatModel deepSeekChatModel){
        String content =  deepSeekChatModel.call("你好你是谁");
        System.out.println(content);
    }

    @Test
    public void testDeepseekStream(@Autowired DeepSeekChatModel deepSeekChatModel){
        Flux<String> stream =  deepSeekChatModel.stream("你好你是谁");
        stream.toIterable().forEach(System.out::println);
    }
}
