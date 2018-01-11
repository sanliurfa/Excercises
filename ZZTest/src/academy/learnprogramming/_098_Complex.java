package academy.learnprogramming;

public class _098_Complex {

	private final double real;
	private final double imaginary;

	public _098_Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public double getReal() {
		return real;
	}

	public double getImaginary() {
		return imaginary;
	}

	public _098_Complex plus(_098_Complex b) {
		double newReal = real + b.real;
		double newImaginary = imaginary + b.imaginary;
		return new _098_Complex(newReal, newImaginary); // je maakt hiermee een nieuwe object aan met hierin nieuw
														// waarden.

	}

	public _098_Complex minus(_098_Complex b) {
		double newReal = real - b.real;
		double newImaginary = imaginary - b.imaginary;
		return new _098_Complex(newReal, newImaginary); // je maakt hiermee een nieuwe object aan met hierin nieuw
														// waarden.

	}

	public _098_Complex times(_098_Complex b) {
		double newReal = real * b.real - imaginary * b.imaginary;
		double newImaginary = real * b.imaginary + imaginary * b.real;
		return new _098_Complex(newReal, newImaginary); // je maakt hiermee een nieuwe object aan met hierin nieuw
														// waarden.

	}

	public static _098_Complex plus(_098_Complex a, _098_Complex b) {
		// double real = a.real + b.real;
		// double imaginary = a.imaginary + b.imaginary;
		// return new _098_Complex(real, imaginary);

		return a.plus(b); // Je kan de bovenstaande ook korter schrijven.
	}

	public static void main(String[] args) {
		_098_Complex a = new _098_Complex(5.0, 6.0);
		_098_Complex b = new _098_Complex(-3.0, 4.0);
		
		_098_Complex bPlusA = b.plus(a);		// Je kan dit ook schrijven als _098_Complex bPlusA = _098_Complex(a, b); 
		
		
		System.out.println("a real= "+ a.real + " imaginary= "+ a.imaginary);
		System.out.println("b real= "+ b.real + " imaginary= "+ b.imaginary);
		System.out.println("b+ a real= "+ bPlusA.real + " imaginary= "+ bPlusA.imaginary);

	}

}
