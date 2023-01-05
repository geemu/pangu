//package com.github.geemu.pangu.backend.config;
//
//import com.fasterxml.jackson.datatype.jsr310.ser.*;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.*;
//import java.time.format.DateTimeFormatter;
//
///**
// * Java8时间格式化
// * @author 陈方明  cfmmail@sina.com
// * @since 2021-11-07 15:32
// */
//@Configuration
//public class Java8TimeConfig {
//
//    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss.SSSSSS}")
//    private String localDateTime;
//
//    /**
//     * Java8时间格式化
//     * @return Jackson2ObjectMapperBuilderCustomizer
//     */
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> {
//            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(localDateTime)));
//            builder.serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            builder.serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
//            builder.serializerByType(YearMonth.class, new YearMonthSerializer(DateTimeFormatter.ofPattern("yyyy-MM")));
//            builder.serializerByType(MonthDay.class, new MonthDaySerializer(DateTimeFormatter.ofPattern("MM-dd")));
//        };
//    }
//
//}
