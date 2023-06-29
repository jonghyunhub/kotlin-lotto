package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BounsBallTest {
    @Test
    fun `보너스 넘버는 숫자 한개를 가진다`() {
        val bounsBall = BounsBall(1)

        assertThat(bounsBall.bounsNumber).isEqualTo(1)
    }

    @Test
    fun `보너스 볼을 생성할 때 1부터 45사이의 숫자를 값으로 가진다`() {
        val numberInOutOfLottoBounce = 46

        assertThrows<IllegalArgumentException> {
            BounsBall(numberInOutOfLottoBounce)
        }
    }
}
