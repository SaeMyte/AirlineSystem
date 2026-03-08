package com.agent.springai.quickstart;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.deepseek.DeepSeekAssistantMessage;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.deepseek.DeepSeekChatOptions;
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

    /**
     * 测试模型通用配置
     *
     * @param deepSeekChatModel deepseek模型实例
     */
    @Test
    public void testChatOptions(@Autowired DeepSeekChatModel deepSeekChatModel){
        DeepSeekChatOptions options = DeepSeekChatOptions.builder().model("deepseek-chat").temperature(1.9d).build();
        ChatResponse chatResponse = deepSeekChatModel.call(new Prompt("请写一首诗描述清晨",options));
        System.out.println(chatResponse.getResult().getOutput().getText());
    }

    /**
     * 测试deepseek推理模型深度思考功能
     *
     * @param deepSeekChatModel deepseek模型实例
     */
    @Test
    public void testDeepseekThinking(@Autowired DeepSeekChatModel deepSeekChatModel){
        Prompt prompt = new Prompt("你好你是谁");
        ChatResponse chatResponse =  deepSeekChatModel.call(prompt);
        DeepSeekAssistantMessage output = (DeepSeekAssistantMessage) chatResponse.getResult().getOutput();
        System.out.println(output.getReasoningContent());
        System.out.println(output.getText());
    }
}
