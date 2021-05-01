package util;

public interface Constants {
	public static final double 	INITIAL_VOLUME = 50,
								VOLUME_FACTOR = 0.001,
								INITIAL_VOLUME_EFFECTS = 50,
								VOLUME_EFFECTS_FACTOR = 0.004;
	
	public static final int NB_QUESTIONS_MAX = 4,
							SIZE_MAX_QUESTION = 60,
							NB_PLAYER = 8,
							ANIMATION_TIME_START = 1500, //3000
							ANIMATION_TIME_RATING = 1750,//2500
							ANIMATION_TIME_ERROR = 1500, //3000
							ANIMATION_TIME_TURN = 3000,
							ANIMATION_TIME_MESSAGE = 3500,
							ANIMATION_TIME_ANSWER=1750,
							ANIMATION_MOVEMENT = 750,
							TIMER_START = 35,
							TIMER_LIMIT = 10,
							STRING_PERCENTAGE_ERROR_ANSWER=20,
							NUMBER_PERCENTAGE_ERROR_ANSWER=2; 
	
	public static final String 	DECK_PATH = "groupeA06.JSON",
								BOARD_PATH= "board.JSON",
								RULE_PATH= "/res/GameRule.txt",
								MUSIC_1_PATH= "musics/bensound-hipjazz.wav",
								CORRECT_ANSWER= "musics/CorrectAnswer.wav",
								INCORRECT_ANSWER= "musics/InCorrectAnswer.wav";
	
	// Size Players	
	public static final double 	PLAYER_HEIGHT = 100, PLAYER_WIDTH = 100;
	
}
