package dev.anubhab.micro_investment_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

//@SpringBootTest
@ContextConfiguration
class MicroInvestmentServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@ParameterizedTest
	@ValueSource(strings = {"Hello", "World", "Test"})
	@NullSource
	void testOptional(String input) {
		Optional<String> value = Optional.ofNullable(input);
		if (value.isPresent()) {
			System.out.println("Value is present: " + value.get());
		} else {
			System.out.println("Value is null");
		}
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"Hello", "World", ""})
	void testOptionalWithNull(String input) {
		String value = Optional.ofNullable(input).orElse("Default Value");
		System.out.println("Value: " + value);
	}
}
