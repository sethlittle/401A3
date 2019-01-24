package a3jedi;

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
		_pixels[x][y] = p;
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

	public double unequalPixelRatio(Picture p) {
		if (this.getHeight() == p.getHeight() && this.getWidth() == p.getWidth()) {
			double total = 0.0;
			double count = 0.0;

			for (int i = 0; i < p.getWidth(); i++) {
				for (int j = 0; j < p.getHeight(); j++) {
					if (!(this.getPixel(i, j).equals(p.getPixel(i, j)))) {
						total++;
						count++;
					} else {
						total++;
					}
				}
			}

			double ratio = count / total;

			return ratio;

		} else {
			throw new RuntimeException("The object and the parameter must be the same size");
		}
	}

	public double calculatePSNR(Picture p) {
		if (this.getHeight() == p.getHeight() && this.getWidth() == p.getWidth()) {
			double MSEtotal = 0.0;
			double total = 0.0;
			for (int i = 0; i < p.getWidth(); i++) {
				for (int j = 0; j < p.getHeight(); j++) {
					total++;
					Pixel q = p.getPixel(i, j);
					Pixel r = this.getPixel(i, j);
					double qi = q.getIntensity();
					double ri = r.getIntensity();

					MSEtotal = MSEtotal + (ri - qi) * (ri - qi);

				}
			}

			if (MSEtotal == 0) {
				throw new RuntimeException("The PSNR of two identical Pictures cannot be calculated");
			}

			double MSE = MSEtotal / total;
			double PSNR = -10 * Math.log10(MSE);
			return PSNR;

		} else {
			throw new RuntimeException("The object and the parameter must be the same size");
		}
	}
}
