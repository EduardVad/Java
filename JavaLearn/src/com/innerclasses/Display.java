package com.innerclasses;

public class Display {

	private static final int DISPLAY_HEIGHT = 1920;
	private static final int DISPLAY_WIDTH = 1280;

	public Display() {
		Pixel pixel = new Pixel(1, 15, Color.BLUE);
	};

	private static class Pixel {
		private int x;
		private int y;
		private Color color;

		private Pixel(int x, int y, Color color) {

			if (0 <= x && x <= DISPLAY_WIDTH && 0 <= y && y <= DISPLAY_HEIGHT) {
				this.x = x;
				this.y = y;
				this.color = color;
				System.out.println("Color = " + color + " at " + x + "; " + y);
			} else {
				throw new IllegalArgumentException("Coordinates of x and y should be in range");
			}

		}

	}

	public enum Color {
		BLACK, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, WHITE
	}

}
