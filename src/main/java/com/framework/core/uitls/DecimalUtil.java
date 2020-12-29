package com.framework.core.uitls;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 浮点数计算工具类
 */
public class DecimalUtil {

	/**
	 * 计算俩个double相乘
	 * @param d1
	 * @param d2
	 */
	public static double multiply(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 计算俩个int相乘
	 * @param d1
	 * @param d2
	 */
	public static int multiply(int d1, int d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.multiply(b2).intValue();
	}

	/**
	 * 计算俩个double相除,精度为2
	 * @param d1
	 * @param d2
	 */
	public static double division(double d1, double d2){
		return division(d1, d2, 2);
	}

	/**
	 * 计算俩个int相除,精度为2
	 * @param d1
	 * @param d2
	 */
	public static double division(int d1, int d2){
		return division(d1, d2, 2);
	}

	/**
	 * 计算俩个double相除
	 * @param d1
	 * @param d2
	 * @param scale 小数位数
	 */
	public static double division(double d1, double d2, int scale){
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.divide(b2,scale, RoundingMode.UP).doubleValue();
	}

	/**
	 * 计算俩个double相减
	 * @param d1
	 * @param d2
	 */
	public static double subtract(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.subtract(b2).doubleValue();
	}
	

	/**
	 * 计算俩个double相加
	 * @param d1
	 * @param d2
	 */
	public static double add(double d1, double d2) {
		BigDecimal b1 = new BigDecimal(d1);
		BigDecimal b2 = new BigDecimal(d2);
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * 计算double数组之和
	 * @param array
	 * @return
	 */
	public static double addArray(double[] array) {
		BigDecimal result = new BigDecimal(0d);
		for (int i = 0; i < array.length; i++) {
			result = result.add(new BigDecimal(array[i]));
		}
		return result.doubleValue();
	}

	/**
	 * 格式化double
	 * @param d1 数值
	 * @param newScale 小数位数
	 * @param RoundingMode 舍入方式
	 */
	public static double setScale(double d1, int newScale, RoundingMode RoundingMode) {
		BigDecimal result = new BigDecimal(d1);
		result.setScale(newScale, RoundingMode);
		return result.doubleValue();
	}

	/**
	 * 把double转为int 在转成string
	 */
	public static String doubleToIntStr(double d) {
		return String.valueOf(Double.valueOf(d).intValue());
	}
}

