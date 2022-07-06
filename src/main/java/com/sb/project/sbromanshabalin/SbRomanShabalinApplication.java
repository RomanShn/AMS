package com.sb.project.sbromanshabalin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Главный класс для запуска
 */
@SpringBootApplication
@EnableScheduling
public class SbRomanShabalinApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SbRomanShabalinApplication.class, args);
    }

}
