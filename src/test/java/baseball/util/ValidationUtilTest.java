package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 8:51 PM
 */
public class ValidationUtilTest {
    @Test
    @DisplayName("숫자 validation")
    void 숫자_1_9_까지_validation(){
    	// given

    	// when
    
    	// then
        assertThat(ValidationUtil.checkNo(9)).isTrue();
        assertThat(ValidationUtil.checkNo(1)).isTrue();
        assertThat(ValidationUtil.checkNo(0)).isFalse();
        assertThat(ValidationUtil.checkNo(10)).isFalse();
    }
}
