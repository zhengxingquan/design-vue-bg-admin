package com.quan.generator.core;

import com.quan.BgGeneratorCenterApplication;
import com.quan.core.rabbitmq.service.SysGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/16
 * 描述：
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BgGeneratorCenterApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeneratorCodeTest {

    @Autowired
    private SysGeneratorService sysGeneratorService;

    @Test
    public void test1() throws Exception {
        OutputStream stream = new FileOutputStream(new File("D:/demo/"));
        byte[] bytes = sysGeneratorService.generatorCode(new String[]{"sys_user"});
        IOUtils.write(bytes, stream);

    }
}
