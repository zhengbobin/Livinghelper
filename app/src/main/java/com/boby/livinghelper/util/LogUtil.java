package com.boby.livinghelper.util;

import android.util.Log;

/**
 *	功能：用于处理日志
 *
 * @author zbobin.com
 * @date 2015/4/28.
 */

public class LogUtil {
	private static boolean DEBUG =true;

	/**
	 * 用于显示错误信息
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	public static void e(String paramString1, String paramString2) {
		if (DEBUG) {
			Log.e(paramString1, paramString2);
		}
	}

	/**
	 * 用于显示调试信息
	 *
	 * @param paramString1
	 * @param paramString2
	 */
	public static void d(String paramString1, String paramString2) {
		if (DEBUG) {
			Log.d(paramString1, paramString2);
		}
	}

	/**
	 * 用于显示警告信息
	 *
	 * @param paramString1
	 * @param paramString2
	 */
	public static void w(String paramString1, String paramString2) {
		if (DEBUG) {
			Log.w(paramString1, paramString2);
		}
	}

	/**
	 * 用于显示一般性的信息
	 * 
	 * @param paramString1
	 * @param paramString2
	 */
	public static void i(String paramString1, String paramString2) {

		if (DEBUG) {
			Log.i(paramString1, paramString2);
		}

	}

}
