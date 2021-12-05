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
// * com.github.geemu.pangu.backend.config
// * @author 陈方明  cfmmail@sina.com
// * @since 2021-11-07 15:32
// */
//@Configuration
//public class Java8TimeConfiguration {
//
//    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm}")
//    private String FORMAT_LOCAL_DATE_TIME_STYLE;
//
//    private static final String FORMAT_LOCAL_DATE = "yyyy-MM-dd";
//
//    private static final String FORMAT_LOCAL_TIME_STYLE = "HH:mm:ss";
//
//    private static final String FORMAT_YEAR_MONTH_STYLE = "yyyy-MM";
//
//    private static final String FORMAT_MONTH_DAY_STYLE = "MM-dd";
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> {
//            // 日期时间序列化
//            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(FORMAT_LOCAL_DATE_TIME_STYLE)));
//            // 日期序列化
//            builder.serializerByType(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(FORMAT_LOCAL_DATE)));
//            // 时间序列化
//            builder.serializerByType(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(FORMAT_LOCAL_TIME_STYLE)));
//            // 年月序列化
//            builder.serializerByType(YearMonth.class, new YearMonthSerializer(DateTimeFormatter.ofPattern(FORMAT_YEAR_MONTH_STYLE)));
//            // 月日序列化
//            builder.serializerByType(MonthDay.class, new MonthDaySerializer(DateTimeFormatter.ofPattern(FORMAT_MONTH_DAY_STYLE)));
//        };
//    }
//
//}
