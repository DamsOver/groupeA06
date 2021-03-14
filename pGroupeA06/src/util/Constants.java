package util;

public interface Constants {
	public static final double 	INITIAL_VOLUME = 0,
								VOLUME_FACTOR = 0.001;
	public static final int NB_QUESTIONS_MAX = 4,
							SIZE_MAX_QUESTION = 65,
							ANIMATION_TIME_START = 1000, //3000
							ANIMATION_TIME_RATING = 1000,//2500
							ANIMATION_TIME_ERROR = 1000, //3000
							ANIMATION_TIME_TURN = 1000, 
							TIMER_START = 25,
							TIMER_LIMIT = 5,
							STRING_PERCENTAGE_ERROR_ANSWER=20,
							NUMBER_PERCENTAGE_ERROR_ANSWER=2; 
	public static final String DECK_PATH = "deck.JSON",
								BOARD_PATH= "board.JSON";
}
