package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 8:09 PM
 */
public class GameTest {

    @Test
    @DisplayName("play")
    void play_3_strike(){
    	// given
        Game game = new Game(Arrays.asList(1,2,3));
    	// when
        GameResult result = game.play(Arrays.asList(1, 2, 3));
        System.out.println("result.getResult() = " + result.getResult());
    	// then
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrke()).isEqualTo(3);
    }

    @Test
    @DisplayName("뽈")
    void 뽈(){
        // given
        Game game = new Game(Arrays.asList(1,2,3));
        // when
        GameStatus status = game.play(new Ball(1, 2));
        // then
        assertThat(status).isEqualTo(GameStatus.BALL);
    }

    @Test
    @DisplayName("낫띵")
    void 낫띵(){
    	// given
        Game game = new Game(Arrays.asList(2,2,3));
        // when
        GameStatus status = game.play(new Ball(1, 4));
    	// then
        assertThat(status).isEqualTo(GameStatus.NOTING);
    }
}
