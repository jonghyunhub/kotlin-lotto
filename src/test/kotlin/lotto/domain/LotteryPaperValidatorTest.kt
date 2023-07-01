package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LotteryPaperValidatorTest {

    private lateinit var lotteryPaperValidator: LotteryPaperValidator

    @BeforeEach
    fun setUp() {
        lotteryPaperValidator = LotteryPaperValidator()
    }

    @Test
    fun `로또 용지에 중복이 생기면 IllegalArgumentException을 throw한다`() {
        val numberList = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = numberList.map { LottoNumber(it) }

        val lotteryPaperList = listOf(
            LotteryPaper(lottoNumbers),
            LotteryPaper(lottoNumbers)
        )

        assertThrows<IllegalArgumentException> {
            lotteryPaperValidator.validateDuplicateLotteryPaper(lotteryPaperList)
        }
    }

    @Test
    fun `새로 생성한 로또 용지가 이미 존재하면 IllegalArgumentException을 throw한다`() {
        val numberList = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = numberList.map { LottoNumber(it) }

        val lotteryPaperList = listOf(
            LotteryPaper(lottoNumbers)
        )

        val newGeneratedLotteryPaper = LotteryPaper(lottoNumbers)

        Assertions.assertThat(
            lotteryPaperValidator.isAlreadyExistLotteryPaper(
                lotteryPaperList,
                newGeneratedLotteryPaper
            )
        ).isEqualTo(true)
    }
}
