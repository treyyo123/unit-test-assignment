/**
 * 
 */
package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;;

/**
 * 
 */
class TestDemoJUnitTest {

	private TestDemo testDemo;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	private static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, 2, 2, true),
				arguments(1, 0, 1, true),
				arguments(-6, 8, 2, true),
				arguments(6, -3, 3, true));
		//@formatter:on
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(12, 5)).isEqualTo(17);
		assertThat(testDemo.addPositive(18, 2)).isEqualTo(20);
		assertThat(testDemo.addPositive(2, 3)).isEqualTo(5);
		assertThat(testDemo.addPositive(1012, 597)).isEqualTo(1609);

	}

	/*
	 * Test takes a string and boolean and checks if an exception is expected as
	 * specified in the Stream. If an Exception is not expected then the test checks
	 * that the string does not contain any numbers, if it does then the test
	 * asserts that the string is an instance of an Illegal Argument Exception.
	 */
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForContainsNoNumbers")
	void assertThatStringContainsNoNumbers(String string, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.containsNoNumbers(string)).isEqualTo(true);
		} else {
			assertThatThrownBy(() -> testDemo.containsNoNumbers(string)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	private static Stream<Arguments> argumentsForContainsNoNumbers() {
		//@formatter:off
		return Stream.of(
				arguments("test", false),
				arguments("happy", false),
				arguments("1test", true),
				arguments("t1est", true),
				arguments("te1st", true),
				arguments("tes1t", true),
				arguments("test1", true)
				);
		//@formatter:on
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}// end of class

