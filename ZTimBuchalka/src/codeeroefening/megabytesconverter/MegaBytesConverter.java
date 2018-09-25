package codeeroefening.megabytesconverter;

public class MegaBytesConverter {

	public static void main(String[] args) {

		MegaBytesConverter.printMegaBytesAndKiloBytes(3000);

	}

	public static void printMegaBytesAndKiloBytes(int kiloBytes) {
		int YY = 0;
		int ZZ = 0;

		if (kiloBytes < 0) {
			System.out.println("Invalid Value");
		} else {
			if (kiloBytes > 1024) {
				YY = kiloBytes / 1024;
				ZZ = kiloBytes - (YY * 1024);
			} else if (kiloBytes == 1024) {
				YY = (kiloBytes % 1024) + 1;
				ZZ = 0;
			} else {
				ZZ = kiloBytes;
			}
			System.out.println(kiloBytes + " KB = " + YY + " MB and " + ZZ + " KB");
		}

	}

}
