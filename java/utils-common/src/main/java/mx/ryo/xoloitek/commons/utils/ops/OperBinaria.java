package mx.ryo.xoloitek.commons.utils.ops;

public class OperBinaria {
	
	/**
	 * 
	 * @param binarioA ejemplo: 10101
	 * @param binarioB ejemplo 10100
	 * @return
	 */
	public final static String and(String binarioA, String binarioB) {
		return Integer.toBinaryString(Integer.parseInt(binarioA, 2)
				& Integer.parseInt(binarioB, 2));
	}
	
	/**
	 * 
	 * @param binarioA ejemplo: 10101
	 * @param binarioB ejemplo 10100
	 * @return
	 */
	public final static String or(String binarioA, String binarioB) {
		return Integer.toBinaryString(Integer.parseInt(binarioA, 2)
				& Integer.parseInt(binarioB, 2));
	}
}
