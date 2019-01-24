package a3novice;

public class ColorPixel implements Pixel {

	private double _intensity;
	private double _r;
	private double _g;
	private double _b;

	public ColorPixel(double red, double green, double blue) {
		if (red > 1.0 || red < 0.0 || green > 1.0 || green < 0.0 || blue > 1.0 || blue < 0.0) {
			throw new RuntimeException("Colors must be between 0.0 and 1.0");
		} else {
			_r = red;
			_g = green;
			_b = blue;
			_intensity = (0.299 * red) + (0.587 * green) + (0.114 * blue);
		}
	}

	public double getRed() {
		return _r;
	}

	public double getGreen() {
		return _g;
	}

	public double getBlue() {
		return _b;
	}

	public double getIntensity() {
		return _intensity;
	}

	public char getChar() {
		double i = _intensity;
		if (i >= 0.0 && i < 0.10) {
			return '#';
		} else if (i >= 0.10 && i < 0.20) {
			return 'M';
		} else if (i >= 0.20 && i < 0.30) {
			return 'X';
		} else if (i >= 0.30 && i < 0.4) {
			return 'D';
		} else if (i >= 0.40 && i < 0.5) {
			return '<';
		} else if (i >= 0.50 && i < 0.6) {
			return '>';
		} else if (i >= 0.60 && i < 0.7) {
			return 's';
		} else if (i >= 0.70 && i < 0.8) {
			return ':';
		} else if (i >= 0.80 && i < 0.9) {
			return '-';
		} else if (i >= 0.90 && i <= 1.0) {
			return ' ';
		} else {
			throw new RuntimeException("intensity must be between 0.0 and 1.0");
		}
	}

}
