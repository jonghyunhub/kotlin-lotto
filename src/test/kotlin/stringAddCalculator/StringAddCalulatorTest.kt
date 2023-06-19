package stringAddCalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalulatorTest {

    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource()
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isSameAs(text?.toInt())
    }
}
