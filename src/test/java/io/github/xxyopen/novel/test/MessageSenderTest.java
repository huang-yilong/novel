package io.github.xxyopen.novel.test;

import io.github.xxyopen.novel.NovelApplication;
import io.github.xxyopen.novel.core.constant.MessageSenderTypeConsts;
import io.github.xxyopen.novel.manager.message.AbstractMessageSender;
import io.github.xxyopen.novel.manager.message.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Objects;

/**
 * @Author hyl
 * @Date 2024/2/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NovelApplication.class)
public class MessageSenderTest{

    @Autowired
    private Map<String, AbstractMessageSender> messageSenders;

    @Test
    public void test() {
        MessageSender registerMailSender = messageSenders.get(
                MessageSenderTypeConsts.REGISTER_MAIL_SENDER);
        if (Objects.nonNull(registerMailSender)) {
            registerMailSender.sendMessage(11111L, "304080325@qq.com", "huangyilong");
        }
        MessageSender seckillSysNoticeSender = messageSenders.get(
                MessageSenderTypeConsts.SECKILL_SYS_NOTICE_SENDER);
        if (Objects.nonNull(registerMailSender)) {
            seckillSysNoticeSender.sendMessage(11111L, "全场商品", "今晚 9 点", "www.xxyopen.com");
        }
    }

}
