package a3jedi;

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

	public Pixel blend(Pixel p, double weight) {
		if (weight >= 0.0 && weight <= 1.0) {
			double red;
			double green;
			double blue;

			red = ((weight * this.getRed()) + ((1 - weight) * p.getRed()));
			green = ((weight * this.getGreen()) + ((1 - weight) * p.getGreen()));
			blue = ((weight * this.getBlue()) + ((1 - weight) * p.getBlue()));

			Pixel newPixel = new ColorPixel(red, green, blue);
			return newPixel;
		} else {
			throw new RuntimeException("Weight value must be between 0.0 and 1.0");
		}
	}

	public Pixel lighten(double factor) {
		if (factor >= 0.0 && factor <= 1.0) {
			factor = 1 - factor;
			Pixel whitePixel = new ColorPixel(1.0, 1.0, 1.0);
			Pixel newPixel = this.blend(whitePixel, factor);
			return newPixel;
		} else {
			throw new RuntimeException("Factor must be between 0.0 and 1.0");
		}
	}

	public Pixel darken(double factor) {
		if (factor >= 0.0 && factor <= 1.0) {
			factor = 1 - factor;
			Pixel blackPixel = new ColorPixel(0, 0, 0);
			Pixel newPixel = this.blend(blackPixel, factor);
			return newPixel;
		} else {
			throw new RuntimeException("Factor must be between 0.0 and 1.0");
		}
	}

	public boolean equals(Pixel p) {
		if (p.getIntensity() > this.getIntensity()) {
			if (Math.abs(_r - p.getRed()) < ((0.10) * p.getIntensity())
					&& Math.abs(_g - p.getGreen()) < ((0.10) * p.getIntensity())
					&& Math.abs(_b - p.getBlue()) < ((0.10) * p.getIntensity())) {
				return true;
			} else {
				return false;
			}
		} else if (this.getIntensity() > p.getIntensity()) {
			if (Math.abs(_r - p.getRed()) < ((0.10) * this.getIntensity())
					&& Math.abs(_g - p.getGreen()) < ((0.10) * this.getIntensity())
					&& Math.abs(_b - p.getBlue()) < ((0.10) * this.getIntensity())) {
				return true;
			} else {
				return false;
			}
		} else {
			if (Math.abs(_r - p.getRed()) < ((0.10) * this.getIntensity())
					&& Math.abs(_g - p.getGreen()) < ((0.10) * this.getIntensity())
					&& Math.abs(_b - p.getBlue()) < ((0.10) * this.getIntensity())) {
				return true;
			} else {
				return false;
			}
		}
	}

}
