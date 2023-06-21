package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    private lateinit var lottoNumbers: LottoNumbers

    @BeforeEach
    fun setUp() {
        lottoNumbers = LottoNumbers()
    }

    @Test
    fun `1부터 45까지 숫자중 6개의 숫자를 무작위로 로또 번호를 생성한다`() {
        val generatedLottoNumber = lottoNumbers.generateRandomLottoNumbers()
        Assertions.assertThat(generatedLottoNumber).hasSize(6).allMatch { it in 1..45 }
    }

    @Test
    fun `생성된 로또 번호는 중복이 없다`() {
        val generatedLottoNumber = lottoNumbers.generateRandomLottoNumbers()
        Assertions.assertThat(generatedLottoNumber.size).isEqualTo(generatedLottoNumber.toSet().size)
    }
}
