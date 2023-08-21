package com.m2p.JunitParametrizedTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class MethodSourceTest {
    Logger LOGGER = LoggerFactory.getLogger(MethodSourceTest.class);

    // @MethodSource for Single Argument

    @ParameterizedTest
    @MethodSource("stringProvider")
    public void methodSource(String inputText)
    {
        assertNotNull(inputText);
    }

    public static Stream<String> stringProvider()
    {
        return Stream.of("Vicky","Dog","Cat");
    }


    // @MethodSource for Multiple Arguments

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void methodSourceArgumentsTest(String inputText,String expected)
    {
        StringHelper stringHelper = new StringHelper();
        assertEquals(expected,stringHelper.reverse(inputText));
    }

    public static Stream<Arguments> argumentsProvider()
    {
        return Stream.of(
                Arguments.of("car","rac"),
                Arguments.of("mom","mom"),
                Arguments.of("rave","evar")
        );
    }
}
