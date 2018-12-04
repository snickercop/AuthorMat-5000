package cs11F;

public class GeneralMethods {
	public static double[] addArrays(double[] array1, double[] array2) {
		double[] output = new double[array1.length];
		for(int i = 0; i < array1.length; i++) {
			output[i] = array1[i] + array2[i];
		}
		return output;
	}
}
