package a3adept;

public class PictureImpl implements Picture {

	private int _width;
	private int _height;
	private Pixel[][] _pixels;

	public PictureImpl(int width, int height) {
		_width = width;
		_height = height;
		_pixels = new Pixel[width][height];

		for (int i = 0; i < _width; i++) {
			for (int j = 0; j < _height; j++) {
				_pixels[i][j] = new ColorPixel(0.5, 0.5, 0.5);
			}
		}
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public void setPixel(int x, int y, Pixel p) {
		if (p != null) {
			_pixels[x][y] = p;
		} else {
			throw new RuntimeException("Pixel p cannot have null as the value");
		}
	}

	public Pixel getPixel(int x, int y) {
		return _pixels[x][y];
	}

	public int countRange(double low, double high) {
		int count = 0;
		if (low <= 1.0 && low >= 0.0 && high <= 1.0 && high >= 0.0) {
			for (int i = 0; i < _width; i++) {
				for (int j = 0; j < _height; j++) {
					if (_pixels[i][j].getIntensity() <= high && _pixels[i][j].getIntensity() >= low) {
						count++;
					}
				}
			}
			return count;
		} else {
			throw new RuntimeException("Low and high must be between 0 and 1");
		}
	}

	public void print() {
		for (int i = 0; i < _width; i++) {
			for (int j = 0; j < _height; j++) {
				if (i == _width - 1) {
					System.out.println(_pixels[i][j].getChar());
				} else {
					System.out.print(_pixels[i][j].getChar());
				}
			}
		}
	}

}
