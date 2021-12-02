package me.mcblueparrot.spade;

import java.io.PrintStream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class SpadePrintStream extends PrintStream {

	private Logger logger = Spade.getLogger();
	private Level level;

	public SpadePrintStream(PrintStream out, Level level) {
		super(out);
		this.level = level;
	}

	@Override
	public void println(boolean x) {
		log(level, x);
	}

	@Override
	public void println(char x) {
		log(level, x);
	}

	@Override
	public void println(char[] x) {
		log(level, x);
	}

	@Override
	public void println(double x) {
		log(level, x);
	}

	@Override
	public void println(float x) {
		log(level, x);
	}

	@Override
	public void println(int x) {
		log(level, x);
	}

	@Override
	public void println(long x) {
		log(level, x);
	}

	@Override
	public void println(Object x) {
		log(level, x);
	}

	@Override
	public void println(String x) {
		log(level, x);
	}

	private void log(Level level, Object x) {
		logger.log(level, x);
	}

}
