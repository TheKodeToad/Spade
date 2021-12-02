package me.mcblueparrot.spade.chat;

/**
 * Represents formatting used in chat
 */
public class Formatting {

	public static final Formatting BLACK = new Formatting('0');
	public static final Formatting DARK_BLUE = new Formatting('1');
	public static final Formatting DARK_GREEN = new Formatting('2');
	public static final Formatting DARK_AQUA = new Formatting('3');
	public static final Formatting DARK_RED = new Formatting('4');
	public static final Formatting DARK_PURPLE = new Formatting('5');
	public static final Formatting GOLD = new Formatting('6');
	public static final Formatting GRAY = new Formatting('7');
	public static final Formatting GREY = GRAY;
	public static final Formatting DARK_GRAY = new Formatting('8');
	public static final Formatting DARK_GREY = DARK_GRAY;
	public static final Formatting BLUE = new Formatting('9');
	public static final Formatting GREEN = new Formatting('a');
	public static final Formatting AQUA = new Formatting('b');
	public static final Formatting RED = new Formatting('c');
	public static final Formatting LIGHT_PURPLE = new Formatting('d');
	public static final Formatting YELLOW = new Formatting('e');
	public static final Formatting WHITE = new Formatting('f');
	public static final Formatting OBFUSCATED = new Formatting('k');
	public static final Formatting BOLD = new Formatting('l');
	public static final Formatting STRIKETHROUGH = new Formatting('m');
	public static final Formatting UNDERLINE = new Formatting('n');
	public static final Formatting ITALIC = new Formatting('o');
	public static final Formatting RESET = new Formatting('r');

	private char character;

	/**
	 * Creates a {@link Formatting} from a character
	 * @param character The character
	 */
	public Formatting(char character) {
		this.character = character;
	}

	/**
	 * Gets the character
	 * @return The character
	 */
	public char getCharacter() {
		return character;
	}

	@Override
	public String toString() {
		return "§" + character;
	}

	public String plus(String append) {
		return this + append;
	}

}
