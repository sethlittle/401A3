package a3novice;

public class GrayPixel implements Pixel {

	private double _intensity;
	private double _r;
	private double _g;
	private double _b;

	public GrayPixel(double intensity) {
		if (intensity >= 0.0 && intensity <= 1.0) {
			_r = intensity;
			_g = intensity;
			_b = intensity;
			_intensity = intensity;

			// by definition of grayscale

		} else {
			throw new RuntimeException("The input is not within the bounds");
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
