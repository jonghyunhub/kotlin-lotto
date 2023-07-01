package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryPaperTest {

    @ParameterizedTest
    @CsvSource("1,2,3,4,5,6", "2,3,10,43,45,6", delimiter = ',')
    fun `당첨 번호를 입력받아서 당첨번호를 생성한다`(input: String) {
        val numberList = input.split(',').map { LottoNumber(it.toInt()) }

        val winningNumber = LotteryPaper(numberList)
        val winningLottoNumber = winningNumber.getLottoNumbers()

        Assertions.assertThat(winningLottoNumber).isEqualTo(numberList)
    }

    @ParameterizedTest
    @CsvSource("1,1,3,4,5,6", "45,45,3,4,5,6", delimiter = ' ')
    fun `당첨 번호는 중복이 있으면 안된다`(input: String) {
        val numberList = input.split(',').map { LottoNumber(it.toInt()) }
        assertThrows<IllegalArgumentException> {
            LotteryPaper(numberList)
        }
    }
}
