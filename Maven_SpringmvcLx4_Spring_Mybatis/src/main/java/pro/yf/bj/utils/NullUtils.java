package pro.yf.bj.utils;

import java.util.Map;

public class NullUtils {

	/**
	 * @desc 判断字符串是否为null或空
	 * @param a 字符串
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.isEmpty())
			return true;
		return false;
	}
	
	/**
	 * @desc 判断Map<String, Object>是否为空
	 * @param map
	 * @return
	 */
	public static boolean isNullOrEmpty(Map<String, Object> map) {
		if (map == null || map.keySet().size() == 0)
			return true;
		return false;
	}
}
