package com.jxkj.cjm.common.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

 
 
public class StringUtil {

	public static Log log = LogFactory.getLog(StringUtil.class);

	public static void main(String[] args) throws ClassNotFoundException {
		Class t = Class.forName("com.jxkj.cjm.common.util.StringUtil");
		System.out.println(t);
 		Type parentType = t.getGenericSuperclass();
		System.out.println(parentType);
		// 转成参数类型接口
		ParameterizedType paramterType = (ParameterizedType) parentType;
		// 得到泛型类型
		Type[] types = paramterType.getActualTypeArguments();
		// 得到传入泛型的类
		//entityClass = (Class<Entity>) types[0];
	}

	/**
	 * 删除特定字符
	 */
	public static String deleteAll(String source, char oldc) {

		StringBuffer sbu = new StringBuffer();
		// 字符串的长度
		int lenOfsource = source.length();
		// 指定字符在字符串中的位置
		int i;
		// 从指定位置开始寻找
		int posStart;
		// int indexOf(char ch,int intStart)
		// 如果ch在字符串中的位置大于intStart
		// 返回实际的位置
		// 否则返回0或者-1
		// 此方法原理:
		// 从字符串的第一个位置开始找起
		// 如果找到oldc,就截取从posStart开始到i结束的字符串
		// substring(int begin,int end)不包括结束时的字符
		// 这样就删除了第一次找到的指定字符
		// 由于后面的指定字符肯定在第一次找到的指定字符后面
		// 所以再对指定位置posStart在第一次找到的位置上加1
		// posStart=i+1
		for (posStart = 0; (i = source.indexOf(oldc, posStart)) >= 0; posStart = i + 1) {
			sbu.append(source.substring(posStart, i));
		}

		// 经过上一次循环删除了所有的指定字符
		// 但如果在此字符后面还有字符串
		// 则也要截取到
		// 此时posStart的值是最后一个指定字符的位置+1
		// 如果posStart小于字符串长度,则肯定还有未添加的字符串
		// 所以再加上一个判断
		if (posStart < lenOfsource) {
			sbu.append(source.substring(posStart));
		}

		return sbu.toString();

	}

	/**
	 * 截取有空格的参数去除空格
	 */

	public static String removeNullString(String value) {
		String string = null;
		if (value == null) {
			string = null;
		} else if (value != null) {
			StringTokenizer statSt = new StringTokenizer(value + "", " ");
			while (statSt.hasMoreTokens()) {
				string = statSt.nextToken();
			}
		}
		return string;
	}

	 

	/**
	 * 将一个字串的首字母大写
	 *
	 * @param s
	 *            String 源字串
	 * @return String 首字母大写后的字串
	 */

	public static String toUpperCaseFirstLetter(String s) {

		return isNullStr(s)

				? s

				: s.substring(0, 1).toUpperCase() + s.substring(1);

	}

	/**
	 * 把空字符串转换为empty
	 *
	 * @param s
	 * @return
	 * @see getNotNullStr
	 * @deprecated
	 */

	@Deprecated
	public static final String nullToEmptyOfStr(String s) {

		if (s != null)

			return s.trim();

		else

			return "";

	}

	/**
	 * 取指定字符串的指定长度子字串
	 *
	 * @param strAll
	 * @param strLen
	 * @return
	 */

	public static final String subStr(String strAll, int strLen) {

		String strNew = nullToEmptyOfStr(strAll);

		String myStr = "";

		if (strNew.length() >= strLen) {

			myStr = strNew.substring(0, strLen);

		} else {

			myStr = strNew;

		}

		return myStr;

	}

	// 字符串替换 s 搜索字符串 s1 要查找字符串 s2 要替换字符串
	public static String replace(String s, String s1, String s2) {

		if (s == null)

			return null;

		int i = 0;

		if ((i = s.indexOf(s1, i)) >= 0) {

			char ac[] = s.toCharArray();

			char ac1[] = s2.toCharArray();

			int j = s1.length();

			StringBuffer stringbuffer = new StringBuffer(ac.length);

			stringbuffer.append(ac, 0, i).append(ac1);

			i += j;

			int k;

			for (k = i; (i = s.indexOf(s1, i)) > 0; k = i) {

				stringbuffer.append(ac, k, i - k).append(ac1);

				i += j;

			}

			stringbuffer.append(ac, k, ac.length - k);

			return stringbuffer.toString();

		} else {

			return s;

		}

	}

	/**
	 * convert Array to ArrayList
	 *
	 * @param sz
	 *            String[]
	 * @param len
	 *            int
	 * @return ArrayList
	 */

	public static ArrayList getArrayListFromArray(String[] sz, int len) {

		ArrayList aTmp = new ArrayList();

		if (isNullStr(sz)) {

			for (int i = 0; i < len; i++) {

				aTmp.add("");

			}

		} else {

			for (int i = 0; i < sz.length; i++) {

				aTmp.add(sz[i]);

			}

		}

		return aTmp;

	}

	/**
	 * Convert to int Base200312291149
	 *
	 * @param o
	 *            Object
	 * @return int
	 */

	public static int cNum(Object o) {

		try {

			return Integer.parseInt(cStr(o));

		} catch (Exception ex) {

			return 0;

		}

	}

	/**
	 * Convert to String from object Base200312291148
	 *
	 * @param o
	 *            Object
	 * @return String
	 */

	public static String cStr(Object o) {

		return o == null ? "" : o.toString();

	}

	/**
	 * 判断此字符串是否为空、空字符串，或"null"
	 *
	 * @param str
	 * @return
	 */

	public static boolean isNullStr(String s) {

		return (s == null || s.equals("null") || s.equals("")) ? true : false;

	}

	/**
	 * 如果字符串为空、空字符串，或"null"时返回"0"
	 *
	 * @param str
	 * @return String
	 */

	public static String emptyToZero(String str) {

		if (isNullStr(str))

			return "0";

		else

			return str.trim();

	}

	/**
	 * 判断此字符串是否为空、空字符串，或"null"
	 *
	 * @param str
	 * @return
	 */

	public static boolean isNullStr(Object o) {

		return (

		o == null

				|| o.toString().equals("null")

				|| o.toString().equals(""))

						?

						// return (o==null||o.toString().equals(""))?

						true : false;

	}

	/**
	 * 如果字符串str为空则转换为str1
	 *
	 * @param str
	 * @param str1
	 * @return
	 */

	public static String getNullStr(String str, String str1) {

		if (isNullStr(str))

			return str1;

		else

			return str;

	}

	/**
	 * 将字符串str转换为GBK编码格式
	 *
	 * @param str
	 * @return
	 */

	public static String getGBKStr(String str) {

		try {

			String temp_p;

			temp_p = str;

			// temp_p = getNullStr(temp_p, "");

			temp_p = nullToEmptyOfStr(temp_p);

			byte[] temp_t = temp_p.getBytes("ISO8859_1");

			String temp = new String(temp_t, "GBK");

			return temp;

		} catch (Exception e) {

			return "";

		}

	}

	public static String getISOStr(String str) {

		try {

			String temp_p;

			temp_p = str;

			temp_p = getNullStr(temp_p, "");

			byte[] temp_t = temp_p.getBytes("ISO8859_1");

			String temp = new String(temp_t);

			return temp;

		} catch (Exception e) {
		}

		return "null";

	}

	/**
	 * 将字串转成日期，字串格式: yyyy/MM/dd
	 *
	 * @param string
	 *            String
	 * @return Date
	 * @author Base200312111725
	 */

	public static Date toDate(String string) {

		try {

			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

			return formatter.parse(string);

		} catch (Exception ex) {

			System.err.println(

					"[ com.netgate.web.util.StringUtil.toDate(string) ]"

							+ ex.getMessage());

			return null;

		}

	}

	/**
	 * 将字串转成日期和时间，字串格式: yyyy/MM/dd HH:mm:ss
	 *
	 * @param string
	 *            String
	 * @return Date
	 * @author Base200312111726
	 */

	public static Date toDatetime(String string) {

		try {

			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			return formatter.parse(string);

		} catch (Exception ex) {

			System.err.println(

					"[ com.netgate.web.util.StringUtil.toDatetime(string) ]"

							+ ex.getMessage());

			return null;

		}

	}
	
	/**
	 * String 转化为date
	 * @param @param string
	 * @param @return
	 * @return Date
	 * @author jiangxueyou
	 */
	public static Date stringToDatetime(String string) {

		try {

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			return formatter.parse(string);

		} catch (Exception ex) {

			System.err.println(

					"[ com.netgate.web.util.StringUtil.toDatetime(string) ]"

							+ ex.getMessage());

			return null;

		}

	}
	/**
	 * 把String 字符串转化为时间类型
	 * @param @param string
	 * @param @return
	 * @return Date
	 * @author jiangxueyou
	 */
	public static Date stringToDatetime2(String string) {
		
		try {
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			return formatter.parse(string);
			
		} catch (Exception ex) {
			
			System.err.println(
					
					"[ com.netgate.web.util.StringUtil.toDatetime(string) ]"
					
							+ ex.getMessage());
			
			return null;
			
		}
		
	}

	/**
	 * 判断单选框是否选中
	 *
	 * @param inparam
	 * @param val
	 * @return 是否选中
	 * @author tempnc20031222
	 */

	public static String isChecked(String inparam, String val) {

		try {

			if (inparam.trim().equals(val.trim()))

				return "checked";

			else

				return "";

		} catch (Exception ex) {

			System.err.println(

					"[ com.netgate.web.util.StringUtil.toDatetime(string) ]"

							+ ex.getMessage());

			return null;

		}

	}

	/**
	 * 此方法将给出的字符串source使用delim划分为单词数组。
	 *
	 * @param source
	 *            需要进行划分的原字符串
	 * @param delim
	 *            单词的分隔字符串
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组，
	 *         <p>
	 *         如果delim为null则使用逗号作为分隔字符串。
	 * @since 0.1
	 */

	public static String[] split(String source, String delim) {

		String[] wordLists;

		if (source == null) {

			wordLists = new String[1];

			wordLists[0] = source;

			return wordLists;

		}

		if (delim == null) {

			delim = ",";

		}

		StringTokenizer st = new StringTokenizer(source, delim);

		int total = st.countTokens();

		wordLists = new String[total];

		for (int i = 0; i < total; i++) {

			wordLists[i] = st.nextToken();

		}

		return wordLists;

	}

	/**
	 * 此方法将给出的字符串source使用delim划分为单词数组。
	 *
	 * @param source
	 *            需要进行划分的原字符串
	 * @param delim
	 *            单词的分隔字符
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组。
	 * @since 0.2
	 */

	public static String[] split(String source, char delim) {

		return split(source, String.valueOf(delim));

	}

	/**
	 * 此方法将给出的字符串source使用逗号划分为单词数组。
	 *
	 * @param source
	 *            需要进行划分的原字符串
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组。
	 * @since 0.1
	 */

	public static String[] split(String source) {

		return split(source, ",");

	}

	/**
	 * 将set的所有记录并成一个以 delim 分隔的字符串
	 *
	 * @param set
	 * @param delim
	 * @return
	 */

	public static String combine(Set set, String delim) {

		if (set == null || set.size() == 0) {

			return "";

		}

		if (delim == null) {

			delim = "";

		}

		StringBuffer sb = new StringBuffer(100);

		for (Iterator iter = set.iterator(); iter.hasNext();) {

			sb.append(iter.next());

			sb.append(delim);

		}

		if (sb.length() >= delim.length()) {

			sb.delete(sb.length() - 1 - delim.length(), sb.length() - 1);

		}

		return sb.toString();

	}

	/**
	 * 将set的所有记录并成一个以 , 分隔的字符串
	 *
	 * @param set
	 * @param delim
	 * @return
	 */

	public static String combine(Set set) {

		return combine(set, ",");

	}

	/**
	 * 将字符串数组合并成一个以 delim 分隔的字符串
	 *
	 * @param array
	 *            字符串数组
	 * @param delim
	 *            分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 */

	public static String combineArray(String[] array, String delim) {

		if (array == null || array.length == 0) {

			return "";

		}

		int length = array.length - 1;

		if (delim == null) {

			delim = "";

		}

		StringBuffer result = new StringBuffer(length * 8);

		for (int i = 0; i < length; i++) {

			result.append(array[i]);

			result.append(delim);

		}

		result.append(array[length]);

		return result.toString();

	}

	/**
	 * 将字符串数组合并成一个以,号分隔的字符串
	 *
	 * @param array
	 *            字符串数组
	 * @return 合并后的字符串
	 */

	public static String combineArray(String[] array) {

		return combineArray(array, ",");

	}

	/**
	 * 将字符串数组使用指定的分隔符合并成一个字符串。
	 *
	 * @param array
	 *            字符串数组
	 * @param delim
	 *            分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 * @deprecated
	 */

	@Deprecated
	public static String combineStringArray(String[] array, String delim) {

		return combineArray(array, delim);

	}

	/**
	 * 将int数组使用指定的分隔符合并成一个字符串
	 *
	 * @param array
	 *            int[] int 数组
	 * @param delim
	 *            String 分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return String 合并后的字符串
	 */

	public static String combineArray(int[] array, String delim) {

		if (array == null || array.length == 0) {

			return "";

		}

		int length = array.length - 1;

		if (delim == null) {

			delim = "";

		}

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < length; i++) {

			result.append(Integer.toString(array[i]));

			result.append(delim);

		}

		result.append(Integer.toString(array[length]));

		return result.toString();

	}

	/**
	 * 将int数组合并成一个以,号分隔的字符串
	 *
	 * @param array
	 *            字符串数组
	 * @return 合并后的字符串
	 */

	public static String combineArray(int[] array) {

		return combineArray(array, ",");

	}

	/**
	 * 将字符串List使用指定的分隔符合并成一个字符串。
	 *
	 * @param list
	 *            List
	 * @param delim
	 *            String
	 * @return String
	 */

	public static String combineList(List list, String delim) {

		if (list == null || list.size() == 0) {

			return "";

		} else {

			StringBuffer result = new StringBuffer();

			for (int i = 0; i < list.size() - 1; i++) {

				result.append(list.get(i));

				result.append(delim);

			}

			result.append(list.get(list.size() - 1));

			return result.toString();

		}

	}

	/**
	 * 将字符串List使用 , 合并成一个字符串。
	 *
	 * @param list
	 *            List
	 * @return String
	 */

	public static String combineList(List list) {

		return combineList(list, ",");

	}

	/**
	 * 将字符串List使用指定的分隔符合并成一个字符串。
	 *
	 * @param list
	 *            List
	 * @param delim
	 *            String
	 * @return String
	 * @deprecated see combineList(list, delim)
	 */

	@Deprecated
	public static String combineStringList(List list, String delim) {

		return combineList(list, delim);

	}

	/**
	 * 以指定的字符和长度生成一个该字符的指定长度的字符串。
	 *
	 * @param c
	 *            指定的字符
	 * @param length
	 *            指定的长度
	 * @return 最终生成的字符串
	 * @since 0.6
	 */

	public static String fillString(char c, int length) {

		String ret = "";

		for (int i = 0; i < length; i++) {

			ret += c;

		}

		return ret;

	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 *
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 * @since 0.4
	 */

	public static boolean contains(String[] strings, String string,

			boolean caseSensitive) {

		for (int i = 0; i < strings.length; i++) {

			if (caseSensitive == true) {

				if (strings[i].equals(string)) {

					return true;

				}

			} else {

				if (strings[i].equalsIgnoreCase(string)) {

					return true;

				}

			}

		}

		return false;

	}

	/**
	 * 字符串数组中是否包含指定的字符串。大小写敏感。
	 *
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 * @since 0.4
	 */

	public static boolean contains(String[] strings, String string) {

		return contains(strings, string, true);

	}

	/**
	 * 不区分大小写判定字符串数组中是否包含指定的字符串。
	 *
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 * @since 0.4
	 */

	public static boolean containsIgnoreCase(String[] strings, String string) {

		return contains(strings, string, false);

	}

	/**
	 * 得到字符串的字节长度
	 *
	 * @param source
	 *            字符串
	 * @return 字符串的字节长度
	 * @since 0.6
	 */

	public static int getByteLength(String source) {

		int len = 0;

		for (int i = 0; i < source.length(); i++) {

			char c = source.charAt(i);

			int highByte = c >>> 8;

			len += highByte == 0 ? 1 : 2;

		}

		return len;

	}

	/**
	 * 判断字符是否为双字节字符，如中文
	 *
	 * @param c
	 *            char
	 * @return boolean
	 */

	public static boolean isDoubleByte(char c) {

		return !((c >>> 8) == 0);

	}

	/**
	 * 输出固定字节长度的字符串
	 *
	 * @param source
	 *            String
	 * @param len
	 *            int
	 * @param exChar
	 *            String
	 * @param exStr
	 *            String
	 * @return String
	 */

	public static String getSubStr(String source, int len, String exChar,

			String exStr) {

		if (source == null || getByteLength(source) <= len) {

			return source;

		}

		StringBuffer result = new StringBuffer();

		char c = '\u0000';

		int i = 0, j = 0;

		for (; i < len; j++) {

			result.append(c);

			c = source.charAt(j);

			i += isDoubleByte(c) ? 2 : 1;

		}

		/**
		 *
		 * 到这里i有两种情况：等于len或是len+1，如果是len+1，说明是双字节，并多出一个字节
		 *
		 * 这时候就只能append(exChar)，否则就append(c)
		 *
		 */

		if (i > len) {

			result.append(exChar);

		} else {

			result.append(c);

		}

		result.append(exStr);

		return result.toString();

	}

	public static String getSubStr(String source, int len) {

		return getSubStr(source, len, ".", "...");

	}

	/**
	 * 判断输入参数是否为null返回一个非null的值
	 *
	 * @param s
	 *            String 判断的值
	 * @return String
	 */

	public static String getNotNullStr(String s) {

		return (s == null) ? "" : s.trim();

	}

	/**
	 * 将字符串的第一个字母大写
	 *
	 * @param s
	 *            String
	 * @return String
	 */

	public static String firstCharToUpperCase(String s) {

		if (s == null || s.length() < 1) {

			return "";

		}

		char[] arrC = s.toCharArray();

		arrC[0] = Character.toUpperCase(arrC[0]);

		return String.copyValueOf(arrC);

		/*
		 *
		 * char c = s.charAt(0);
		 *
		 * c = Character.toUpperCase(c);
		 *
		 * return Character.toString(c) + s.substring(1);
		 */

	}

	/**
	 * 根据当前字节长度取出加上当前字节长度不超过最大字节长度的子串
	 *
	 * @param str
	 * @param currentLen
	 * @param MAX_LEN
	 * @return
	 */

	public static String getSubStr(String str, int currentLen, int MAX_LEN) {

		int i;

		for (i = 0; i < str.length(); i++) {

			if (str.substring(0, i + 1).getBytes().length + currentLen > MAX_LEN) {

				break;

			}

		}

		if (i == 0) {

			return "";

		} else {

			return str.substring(0, i);

		}

	}

	private static String[] arrAntiKeys = new String[] { "抗日", "日货", "游行", "示威", "抗议", "钓鱼岛", "法轮", "网络警察",
			"WWTTJJLL" };

	/**
	 * 关键字替换成??
	 *
	 * @param keys
	 * @param arg
	 * @return
	 */

	public static String replaceByKeys(String[] keys, String arg) {

		String sbf = arg;

		String[] getarrAntiKeys = arrAntiKeys;

		if ((keys != null) && (keys.length > 0))
			getarrAntiKeys = keys;

		for (int i = 0; i < getarrAntiKeys.length; i++) {

			sbf = sbf.replaceAll(getarrAntiKeys[i], "??");

		}

		return sbf;

	}

	/**
	 * 关键字删除
	 *
	 * @param parm
	 * @return
	 */

	public static String unicodeReplDel(String parm) {

		int area1min = 9601;

		int area1max = 9794;

		int area2min = 12288;

		int area2max = 12311;

		StringBuffer result = new StringBuffer("");

		if (parm.trim().length() > 0) {

			for (int i = 0; i < parm.length(); i++) {

				char c = parm.charAt(i);

				if (!((c >= area1min && c <= area1max) || (c >= area2min && c <= area2max))) {

					result.append(c);

				}

			}

		}

		return result.toString();

	}

	/**
	 * clob转换String
	 *
	 * @param clob
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String ClobToString(Clob clob) throws SQLException, IOException {
		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}

	/**
	 * 分割字符串
	 *
	 * @param str
	 *            要分割的字符串
	 * @param spilit_sign
	 *            字符串的分割标志
	 * @return 分割后得到的字符串数组
	 */
	public static String[] stringSpilit(String str, String spilit_sign) {
		String[] spilit_string = str.split(spilit_sign);
		if (spilit_string[0].equals("")) {
			String[] new_string = new String[spilit_string.length - 1];
			for (int i = 1; i < spilit_string.length; i++)
				new_string[i - 1] = spilit_string[i];
			return new_string;
		} else
			return spilit_string;
	}

	private static String[] FilterChars = { "<", "'", ">", ",", " ", "%" };

	/**
	 * 验证非法字符
	 *
	 * @return
	 */
	public static boolean validateIllegal(String s) {
		for (int j = 0; j < FilterChars.length; j++) {
			int i = s.indexOf(FilterChars[j]);
			if (i >= 0) {
				return false;
			}
		}
		// String[] str_arr = stringSpilit(s, "");
		// String temp;
		// for (int i = 0; i < str_arr.length; i++) {
		// for (int j = 0; j < FilterChars.length; j++) {
		// if(FilterChars[j].length() > 1){
		// s.substring(0, FilterChars[j].length()-1);
		// }
		// if(FilterChars[j].equals(str_arr[i])){
		// //返回false表示有非法字符
		// return false;
		// }
		// }
		// }
		return true;
	}

	/**
	 * 验证是否有非法字符
	 *
	 * @param s
	 * @return
	 */
	public static boolean validateStr(String s) {
		if (s.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String buzero(String RMBMoney) {
		String RMB = "000000000000";
		String zero_12 = "000000000000";
		DecimalFormat decimalFormat = new DecimalFormat("##############0.00");
		if (StringUtils.isNotBlank(RMBMoney) && RMBMoney.replace(".", "").matches("\\d+")) {
			String refundRMBStr = Double.valueOf((decimalFormat.format(Double.valueOf(RMBMoney)))) * 100 + "";
			String refundRMB_0 = zero_12 + refundRMBStr.substring(0, refundRMBStr.indexOf("."));
			RMB = refundRMB_0.substring(refundRMB_0.length() - 12, refundRMB_0.length());
		}
		return RMB;
	}

	public static String getDateFormate(String resource) {
		String tem3 = "";
		String tem = resource.substring(0, 10);
		String[] tem2 = tem.split("-");
		for (int i = 0; i < tem2.length; i++) {
			tem3 = tem3 + tem2[i];
		}
		return tem3;

	}

	/**
	 * 解析get方式的URL
	 *
	 * @param queryString
	 * @return
	 */
	public Map createMapFromResponse(String queryString) {
		Map map = new HashMap();
		StringTokenizer st = new StringTokenizer(queryString, "&");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			int i = token.indexOf('=');
			if (i > 0) {
				try {
					String key = token.substring(0, i);
					String value = URLDecoder.decode(token.substring(i + 1, token.length()));
					map.put(key, value);
				} catch (Exception ex) {
					// Do Nothing and keep looping through data
				}
			}
		}
		return map;
	}

	/**
	 * 解析以分号隔开的字符串
	 *
	 * @param queryString
	 * @return
	 */
	public Map createMapFromResponseBypoint(String queryString) {
		Map map = new HashMap();
		StringTokenizer st = new StringTokenizer(queryString, ";");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			int i = token.indexOf('=');
			if (i > 0) {
				try {
					String key = token.substring(0, i);
					String value = URLDecoder.decode(token.substring(i + 1, token.length()));
					map.put(key, value);
				} catch (Exception ex) {
					// Do Nothing and keep looping through data
				}
			}
		}
		return map;
	}

	// 取值
	public String null2unknown(String in, Map responseFields) {
		if (in == null || in.length() == 0 || (String) responseFields.get(in) == null) {
			return "No Value Returned";
		} else {
			return (String) responseFields.get(in);
		}
	}

	public static String StringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[ `~!#$%^&*()+=|{}':;',\\[\\].<>/?~！#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	/**
	 * 左补空格或零
	 *
	 * @param strSrcLength
	 * @param strSrc
	 * @param flag
	 *            1: "0" 2: " "
	 * @return strReturn
	 */
	public static String stringLeftPading(int strSrcLength, String strSrc, int flag) {
		String strReturn = "";
		String strtemp = "";
		int curLength = strSrc.trim().length();
		if (strSrc != null && curLength > strSrcLength) {
			strReturn = strSrc.trim().substring(0, strSrcLength);
		} else if (strSrc != null && curLength == strSrcLength) {
			strReturn = strSrc.trim();
		} else {
			if (flag == 1) {
				for (int i = 0; i < (strSrcLength - curLength); i++) {
					strtemp = strtemp + "0";
				}
			} else if (flag == 2) {
				for (int i = 0; i < (strSrcLength - curLength); i++) {
					strtemp = strtemp + " ";
				}
			}
			strReturn = strtemp + strSrc.trim();
		}
		return strReturn;
	}

	/**
	 * 右补空格或零（文字，"0"，30）
	 *
	 * @param strSrcLength
	 * @param strSrc
	 * @param flag
	 *            1: "0" 2: " "
	 * @return strReturn
	 */
	public static String stringRightPading(int strSrcLength, String strSrc, int flag) {
		String strReturn = "";
		String strtemp = "";
		int curLength = strSrc.trim().length();
		if (strSrc != null && curLength > strSrcLength) {
			strReturn = strSrc.trim().substring(0, strSrcLength);
		} else if (strSrc != null && curLength == strSrcLength) {
			strReturn = strSrc.trim();
		} else {
			if (flag == 1) {
				for (int i = 0; i < (strSrcLength - curLength); i++) {
					strtemp = strtemp + "0";
				}
			} else if (flag == 2) {
				for (int i = 0; i < (strSrcLength - curLength); i++) {
					strtemp = strtemp + " ";
				}
			}
			strReturn = strSrc.trim() + strtemp;
		}
		return strReturn;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static String getMd5Base64(String str) {
		try {
			MessageDigest md5;
			Base64 base64 = new Base64();
			md5 = MessageDigest.getInstance("MD5");
			String passwords = new String(base64.encode(md5.digest(str.getBytes("utf-8"))));
			;
			return passwords;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public static String fourString(String source) {
		if (0 == source.length()) {
			return "0000";
		}
		if (1 == source.length()) {
			return "000" + source;
		}
		if (2 == source.length()) {
			return "00" + source;
		}
		if (3 == source.length()) {
			return "0" + source;
		}
		if (4 == source.length()) {
			return source;
		} else {
			return source.substring(0, 4);
		}

	}

	public static String getBillNo(String baseid) {
		Random random = new Random();
		String billNo = StringUtil.fourString(baseid) + String.valueOf(System.currentTimeMillis()).substring(3)
				+ Math.round(random.nextInt(99) * random.nextInt(1));
		return billNo;
	}

	public static String getTradeBillNo(String pre) {
		String billNo = pre + String.valueOf(System.currentTimeMillis()).substring(3) + Math.round(Math.random() * 9);
		return billNo;
	}

	/**
	 * @param Kind
	 *            订单类型（如转账：ZZ）
	 * @param BaseId
	 * @return 字符串的单号
	 * @author
	 * @see 生成订单号
	 */
	public static String getOrderNo(String Kind, Long BaseId) {

		if (BaseId == null || BaseId == 0) {
			BaseId = 1l;
		}
		String idStr = String.valueOf(BaseId);
		if (idStr.length() == 6) {
			idStr = "0" + idStr;
		} else if (idStr.length() == 5) {
			idStr = "00" + idStr;
		} else if (idStr.length() == 4) {
			idStr = "000" + idStr;
		} else if (idStr.length() == 3) {
			idStr = "0000" + idStr;
		} else if (idStr.length() == 2) {
			idStr = "00000" + idStr;
		} else if (idStr.length() == 1) {
			idStr = "000000" + idStr;
		}

		String timeStr = String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		String romdd = String.valueOf(random.nextInt(999999));
		if (romdd.length() == 5) {
			romdd = "0" + romdd;
		} else if (romdd.length() == 4) {
			romdd = "00" + romdd;
		} else if (romdd.length() == 3) {
			romdd = "000" + romdd;
		} else if (romdd.length() == 2) {
			romdd = "0000" + romdd;
		} else if (romdd.length() == 1) {
			romdd = "00000" + romdd;
		}
		return Kind + idStr + timeStr + romdd;
	}

	// 将加密过后的支付密码分隔
	public static String[] splitString(String securityPassword) {

		String[] total = { "", "" };
		int i = securityPassword.length() / 4;
		int j = securityPassword.length() % 4;
		String securityPassword1 = securityPassword.subSequence(0, i).toString();
		String securityPassword2 = securityPassword.subSequence(i, 2 * i).toString();
		String securityPassword3 = securityPassword.subSequence(2 * i, 3 * i).toString();
		String securityPassword4 = securityPassword.subSequence(3 * i, 4 * i + j).toString();
		total[0] = securityPassword1 + securityPassword3;
		total[1] = securityPassword2 + securityPassword4;
		return total;
	}

	public static boolean isEmail(String email) {
		String regular = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w)*";
		Pattern pattern = Pattern.compile(regular);
		boolean flag = false;
		if (StringUtils.isNotBlank(email)) {
			Matcher matcher = pattern.matcher(email);
			flag = matcher.matches();
		}

		return flag;
	}

	public static boolean isMobile(String mobile) {
		String regular = "1[3,4,5,7,8]{1}\\d{9}";
		Pattern pattern = Pattern.compile(regular);
		boolean flag = false;
		if (StringUtils.isNotBlank(mobile)) {
			Matcher matcher = pattern.matcher(mobile);
			flag = matcher.matches();
		}
		return flag;
	}

	// 验证时间是否在1分钟之内 大于1为true 小于1为false
	public static boolean compareTime(Date sendDate, Date now) throws ParseException {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String systemTime = sdf.format(sendDate).toString();
		// String compareTime = sdf.format(now).toString();
		// Date begin = sdf.parse(systemTime);
		// Date end = sdf.parse(compareTime);

		long between = (now.getTime() - sendDate.getTime()) / 1000;// 除以1000是为了转换成秒

		long day = between / (24 * 3600);
		long hour = between % (24 * 3600) / 3600;
		long minute = between % 3600 / 60;
		if (day > 0 || hour > 0 || hour == 0 && day == 0 && minute >= 1) {
			return true;
		} else {
			return false;
		}
	}

	// 验证时间是否在time分钟之内 大于time为true 小于time为false
	public static boolean compareTime(Date sendDate, Date now, int time) throws ParseException {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String systemTime = sdf.format(sendDate).toString();
		// String compareTime = sdf.format(now).toString();
		// Date begin = sdf.parse(systemTime);
		// Date end = sdf.parse(compareTime);

		long between = (now.getTime() - sendDate.getTime()) / 1000;// 除以1000是为了转换成秒

		long day = between / (24 * 3600);
		long hour = between % (24 * 3600) / 3600;
		long minute = between % 3600 / 60;
		if (day > 0 || hour > 0 || hour == 0 && day == 0 && minute >= time) {
			return true;
		} else {
			return false;
		}
	}

	public static String accountNum(String accountNumber) {
		if (accountNumber.trim().length() < 7) {
			int e = 7 - accountNumber.trim().length();
			String s = "0000000";
			String substring = s.substring(0, e);
			return substring + accountNumber;
		} else
			return accountNumber;
	}

	/**
	 * ip
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("HTTP_X_REAL_IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// System.out.println("ip----------------"+ip);
		return ip;

	}

	/**
	 * 通过JSON向前台发送数据
	 *
	 * @param data
	 * @throws IOException
	 */
	public static void sendJsonData(HttpServletResponse response, Object data) throws IOException {
		// HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out;
		out = response.getWriter();
		out.println(data);
		out.flush();
		out.close();

	}
	
	/**
	 * 通过JSON向前台发送数据
	 *
	 * @param data
	 * @throws IOException
	 */
	public static void sendJsonData(HttpServletResponse response, String data) throws IOException {
		// HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out;
		out = response.getWriter();
		out.println(data);
		out.flush();
		out.close();

	}

	public static boolean isNull(String string) {
		return StringUtil.isEmpty(string);
	}

	public static boolean isNotEmpty(Object str) {
		return !isEmpty(str);
	}

	public static boolean isEmpty(Object str) {
		return str == null || "".equals(str) || String.valueOf(str).length() == 0 || String.valueOf(str).matches("\\s*");
	}

	

	/**
	 * 获取4-8位随机数
	 *
	 * @return
	 */
	public static int getN(int num) {
		Random random = new Random();
		int number = 0;
		switch (num) {
		case 4:
			number = random.nextInt(8999) + 1000;
			break;
		case 5:
			number = random.nextInt(89999) + 10000;
			break;
		case 6:
			number = random.nextInt(899999) + 100000;
			break;
		case 7:
			number = random.nextInt(8999999) + 1000000;
			break;
		case 8:
			number = random.nextInt(8999999) + 10000000;
			break;
		default:
			number = random.nextInt(8999999) + 1000000;// 默认7位
			break;
		}
		return number;
	}

	/**
	 * 返回占位符字符串
	 *
	 * @param size
	 *            字符串长度
	 * @return
	 */
	public static String getPlaceholder(int size) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buffer = buffer.append("0");
		}
		return buffer.toString();
	}

	/**
	 * 设置占位符字符串 = 1
	 *
	 * @param str
	 * @param idex
	 *            下标
	 * @return
	 */
	public static String setPlaceholder(String str, int idex) {
		StringBuffer buffer = new StringBuffer(str);
		String ss = buffer.replace(idex, idex + 1, "1").toString();
		return ss;
	}
	/**
	 * 把标的属性从序号1,2,3 转化成30个字符串的占位符
	 * @param @param ttype
	 * @param @return
	 * @return String
	 * @author jiangxueyou
	 */
	public static String numberToString(String ttype){
		String str = "000000000000000000000000000000";
		
		char[] strArray = str.toCharArray();
		System.out.println(strArray[1]);
		
		strArray[Integer.parseInt(ttype)-1] = '1';
		
		String st1 = "";
		for (int i = 0; i < strArray.length; i++) {
			st1 +=strArray[i];
		}
		System.out.println(st1);
		
		return st1;
		
	}
	/**
	 * 把标的债转属性从30位 的字符串转化位 单个数字
	 * @param @param ttype
	 * @param @return
	 * @return int
	 * @author jiangxueyou
	 */
	public static int StringToNumber(String ttype){
		char[] st1 = ttype.toCharArray();
		int flag = 0;
		for (int i = 0; i < st1.length; i++) {
			if(st1[i]=='1'){
				//System.out.println(i);
				flag=i+1;
			}
		}
		return flag;
		
	}
	
	/**
	 * 返回占位符字符串
	 *
	 * @param size
	 *            长度
	 * @param arrs
	 *            数组
	 * @return
	 */
	public static String setPlaceholderForArr(String[] arrs, int size) {
		String str = getPlaceholder(size);
		for (String xx : arrs) {
			str = setPlaceholder(str, Integer.parseInt(xx) - 1);
		}
		return str;
	}

	public static String setPlaceholderForArr1(String[] arrs, int size) {
		String str = getPlaceholder(size);
		for (String xx : arrs) {
			str = setPlaceholder(str, Integer.parseInt(xx));
		}
		return str;
	}

	/**
	 * 设置占位符字符串 = 0
	 *
	 * @param str
	 * @param idex
	 *            下标
	 * @return
	 */
	public static String updatePlaceholder(String str, int idex) {
		StringBuffer buffer = new StringBuffer(str);
		String returnStr = buffer.replace(idex, idex + 1, "0").toString();
		return returnStr;
	}

	/**
	 * 返回占位符字符 = 1 的下标 51个字符
	 *
	 * @param str
	 * @return 下标数组
	 */
	public static String[] getPlaceholderArr(String str) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			String str1 = str.substring(i, i + 1);
			if (str1.equals("1"))
				buffer = buffer.append(String.valueOf(i)).append(",");
		}
		return buffer.substring(0, buffer.length() - 1).split(",");
	}

	/**
	 * 返回占位符字符 = 1 的下标
	 *
	 * @param str
	 * @return 下标数组
	 */
	public static String[] getPlaceholderArrForShow(String str) {
		String buffer = "";
		for (int i = 0; i < str.length(); i++) {
			String str1 = str.substring(i, i + 1);
			if (str1.equals("1"))
				buffer = buffer + String.valueOf(i) + ",";
		}
		return buffer.substring(0, buffer.length() - 1).split(",");
	}

	// 解析占位符
	public static List<Integer> pars(String str) {
		List list = new ArrayList();
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).equals("1")) {

				list.add(i);
			}
		}
		return list;
	}

	// 把string变成list
	// 例如：把“11001011”变成list集合：[1,2,5,7,8]
	public static List<Integer> parsStringToList(String str) {
		List list = new ArrayList();
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).equals("1")) {

				list.add(i + 1);
			}
		}
		return list;
	}

	/**
	 * 生成编号 GJPCRYMD GJGBSJ GJTDSJ
	 *
	 * @param nameno
	 * @return 时间字符串
	 */
	public static String getNameNoForName(String name) {
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1);
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hours = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String m = String.valueOf(c.get(Calendar.MINUTE));
		String s = String.valueOf(c.get(Calendar.SECOND));
		if (month.length() == 1) {
			month = "0" + month;
		}

		if (day.length() == 1) {
			day = "0" + day;
		}
		if (hours.length() == 1) {
			hours = "0" + hours;
		}
		if (m.length() == 1) {
			m = "0" + m;
		}
		if (s.length() == 1) {
			s = "0" + s;
		}
		return name + year + month + day + hours + m + s;
	}

	public static String buildNo(String name) {
		String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
		Random rand = new Random();
		for (int i = 36; i > 1; i--) {
			int index = rand.nextInt(i);
			String tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		for (int i = 0; i < 4; i++) {
			name += array[i];
		}
		return name;
	}
	/**
	 * 生成订单编号 16位
	 *
	 * @param
	 * @return 字符串
	 */
	public static String getNo16() {
		String getNo = getNo();
		return getNo.substring(0, getNo.length()-4);
	}
	
	/**
	 * 生成订单编号
	 *
	 * @param
	 * @return 字符串
	 */
	public static String getNo() {
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1);
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hours = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String m = String.valueOf(c.get(Calendar.MINUTE));
		String s = String.valueOf(c.get(Calendar.SECOND));
		if (month.length() == 1) {
			month = "0" + month;
		}

		if (day.length() == 1) {
			day = "0" + day;
		}
		if (hours.length() == 1) {
			hours = "0" + hours;
		}
		if (m.length() == 1) {
			m = "0" + m;
		}
		if (s.length() == 1) {
			s = "0" + s;
		}
		return year + month + day + hours + m + s + getN(6);
	}

	public static String getNolcId() {
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1);
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hours = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String m = String.valueOf(c.get(Calendar.MINUTE));
		String s = String.valueOf(c.get(Calendar.SECOND));
		if (month.length() == 1) {
			month = "0" + month;
		}

		if (day.length() == 1) {
			day = "0" + day;
		}
		if (hours.length() == 1) {
			hours = "0" + hours;
		}
		if (m.length() == 1) {
			m = "0" + m;
		}
		if (s.length() == 1) {
			s = "0" + s;
		}
		return year + month + day + hours + m + s;
	}

	/**
	 * 生成标编号
	 *
	 * @param
	 * @return 字符串
	 */
	public static String getNoForTenderItem(String name) {
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1);
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hours = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		if (month.length() == 1) {
			month = "0" + month;
		}

		if (day.length() == 1) {
			day = "0" + day;
		}
		if (hours.length() == 1) {
			hours = "0" + hours;
		}
		return name + year + month + day + getN(6);
	}

	/**
	 * 为了识别再次充值
	 *
	 * @param
	 * @return 字符串
	 */
	public static String getRechargeNo() {
		String identifying = "GJKJ";
		Calendar c = Calendar.getInstance();
		String year = String.valueOf(c.get(Calendar.YEAR));
		String month = String.valueOf(c.get(Calendar.MONTH) + 1);
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String hours = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String m = String.valueOf(c.get(Calendar.MINUTE));
		String s = String.valueOf(c.get(Calendar.SECOND));
		if (month.length() == 1) {
			month = "0" + month;
		}

		if (day.length() == 1) {
			day = "0" + day;
		}
		if (hours.length() == 1) {
			hours = "0" + hours;
		}
		if (m.length() == 1) {
			m = "0" + m;
		}
		if (s.length() == 1) {
			s = "0" + s;
		}
		return identifying + year + month + day + hours + m + s + getN(6);
	}

	/**
	 * 日期格式化
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		if (date != null) {
			String dateString = new SimpleDateFormat(pattern).format(date);
			return dateString;
		} else {
			return "";
		}
	}

	/**
	 * 将字符串格式的时间转化为date类型的时间!
	 *
	 * @param dateString
	 * @return
	 */
	public static Date stringforDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将字符串格式的时间转化为date类型的时间!
	 *
	 * @param dateString
	 * @return
	 */
	public static Date stringforDatePoint(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将字符串格式的时间转化为date类型的时间!
	 *
	 * @param dateString
	 * @return
	 */
	public static Date stringforDateTwo(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 设置cookie
	 *
	 * @param response
	 * @param name
	 *            cookie名字
	 * @param value
	 *            cookie值
	 * @param maxAge
	 *            cookie生命周期 以秒为单位
	 */
	public static void addCookie(HttpServletResponse response, HttpServletRequest request) {
		String domain = request.getServerName();
		String name = request.getAttribute("cookieName") + domain;
		String value = name + System.currentTimeMillis();
		int maxAge = 365 * 24 * 3600;

		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}

	/**
	 * 根据名字获取cookie
	 *
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	/**
	 * 根据名字获取cookie值
	 *
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request) {
		String name = request.getAttribute("cookieName") + request.getServerName();
		Cookie c = getCookieByName(request, name);
		String cookieValue = "";
		if (c != null && (c.getName().equalsIgnoreCase(name))) {
			cookieValue = c.getValue();
			// System.out.println(cookieValue);
			// System.out.println(c.getPath());
			// System.out.println(c.getDomain());
		}
		return cookieValue;
	}

	/**
	 * 将cookie封装到Map里面
	 *
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	 /**
     * @Description :去小数点后没用的0
     * @param s
     * @return
     */
    public static String quLing(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

	/**
	 * @author:liuqh
	 * @date:2016年07月14日 15:09:51
	 * @description:字符串数组转字符串例如：传入的是["2","4","1"]，经过该方法后返回的是"1101"
	 */
	public static String stringArrayToString(String[] arr) {
		int max = 0;
		// 找出arr中最大的值
		if (arr != null && arr.length > 0) {
			String s = arr[0];
			max = Integer.valueOf(s);
			for (int i = 0; i < arr.length; i++) {
				int in = Integer.valueOf(arr[i]);
				if (in > max) {
					max = in;
				}
			}
			// 初始化一个数组
			String[] initStrArray = new String[max];
			for (int j = 0; j < max; j++) {
				initStrArray[j] = "0";
			}
			for (int i = 0; i < arr.length; i++) {
				int index = Integer.valueOf(arr[i]) - 1;
				initStrArray[index] = "1";
			}
			// 把字符串数组转为字符串
			String string = "";
			for (int i = 0; i < initStrArray.length; i++) {
				string += initStrArray[i];
			}
			return string;
		}
		return null;
	}

	/**
	 * @author:liuqh
	 * @date:2016年07月14日 15:09:51
	 * @description:数字转字符串例如：传入的是5，经过该方法后返回的是"11111"
	 */
	public static String intToString(int size) {
		String str = "";
		for (int i = 0; i < size; i++) {
			str += "1";
		}
		return str;
	}

	/**
	 * 会员等级模糊查询
	 *
	 * @param intValue
	 * @return str
	 */
	public static String getIndex(int intValue) {
		// TODO Auto-generated method stub
		String index = "";
		for (int i = 0; i < intValue - 1; i++) {
			index += "_";
		}
		return index + "1%";
	}

	/**
	 * @param @param
	 *            length 最大58位
	 * @param @return
	 *            参数说明
	 * @return String 返回类型
	 * @throws @Title:
	 *             getRomdanStr
	 * @Description: TODO(根据长度获取多少个随机码 用于邮箱验证参数 EkJ6ANlubmcjpin4UzrTeHh2QVX93M)
	 * @author chenjiaming
	 */
	public static String getRandomStr(int length) {
		String[] arr = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
				"l", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		while (sb.length() < length) {
			String str = arr[random.nextInt(57)];
			if (sb.indexOf(str) == -1) {
				sb.append(str);
			}
		}
		return sb.toString();
	}

	public static String getOrderNo2(Long BaseId) {

		if (BaseId == null || BaseId == 0) {
			BaseId = 1l;
		}
		String idStr = String.valueOf(BaseId);
		if (idStr.length() == 6) {
			idStr = "0" + idStr;
		} else if (idStr.length() == 5) {
			idStr = "00" + idStr;
		} else if (idStr.length() == 4) {
			idStr = "000" + idStr;
		} else if (idStr.length() == 3) {
			idStr = "0000" + idStr;
		} else if (idStr.length() == 2) {
			idStr = "00000" + idStr;
		} else if (idStr.length() == 1) {
			idStr = "000000" + idStr;
		}

		String timeStr = String.valueOf(System.currentTimeMillis());
		Random random = new Random();
		String romdd = String.valueOf(random.nextInt(999999));
		if (romdd.length() == 5) {
			romdd = "0" + romdd;
		} else if (romdd.length() == 4) {
			romdd = "00" + romdd;
		} else if (romdd.length() == 3) {
			romdd = "000" + romdd;
		} else if (romdd.length() == 2) {
			romdd = "0000" + romdd;
		} else if (romdd.length() == 1) {
			romdd = "00000" + romdd;
		}
		return idStr + timeStr + romdd;
	}

	public static String getOrderNo3(Long BaseId) {

		if (BaseId == null || BaseId == 0) {
			BaseId = 1l;
		}
		String idStr = String.valueOf(BaseId);
		if (idStr.length() == 6) {
			idStr = "6" + idStr;
		} else if (idStr.length() == 5) {
			idStr = "5" + idStr;
		} else if (idStr.length() == 4) {
			idStr = "4" + idStr;
		} else if (idStr.length() == 3) {
			idStr = "3" + idStr;
		} else if (idStr.length() == 2) {
			idStr = "2" + idStr;
		} else if (idStr.length() == 1) {
			idStr = "1" + idStr;
		}

		String timeStr = String.valueOf(System.currentTimeMillis());

		return idStr + timeStr;
	}

	/**
	 * @param @param
	 *            request
	 * @param @return
	 *            参数说明
	 * @return String 返回类型
	 * @throws @Title:
	 *             getBasePath
	 * @Description: TODO(动态获取项目路径)
	 * @author chenjiaming
	 */
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath;
		int prot = request.getServerPort();
		if (prot == 80) {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		}
		return basePath;
	}

	/**
	 * @param @param
	 *            dateStr 日期字符串 2016-08-16
	 * @param @param
	 *            format 格式化的类型(如 yyyy-MM-dd, yyyy-MM-dd hh:mm:ss)
	 * @param @return
	 *            参数说明
	 * @return Date 返回类型
	 * @throws @Title:
	 *             getDateByString
	 * @Description: TODO(将日期字符串转换为Date类型)
	 * @author chenjiaming
	 */
	public static Date getDateByString(String dateStr, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
  
	/**
	 * @param @param
	 *            prefix (前缀 ：如 GJHUODONG )
	 * @param @return
	 *            参数说明 返回GJHUODONG20160830122237
	 * @return String 返回类型
	 * @throws @Title:
	 *             getActno
	 * @Description: TODO(自动生成标的活动设置编号)
	 * @author chenjiaming
	 */
	public static String getActno(String prefix) {
		StringBuffer buffer = new StringBuffer();
		String dateFormat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		int x = (int) (Math.random() * 99999);
		buffer.append(prefix).append(dateFormat).append(String.valueOf(x));
		String actno = buffer.toString();
		return actno;
	}

	/**
	 * @param @param
	 *            specifytnos
	 * @param @return
	 *            参数说明
	 * @return String 返回类型
	 * @throws @Title:
	 *             getLowGrade
	 * @Description: TODO(定向标号/排除标号 去重工具类)
	 * @author chenjiaming
	 */
	public static String getLowGrade(String[] specifytnos) {
		if (specifytnos != null && specifytnos.length > 0) {
			StringBuffer buffer = new StringBuffer();
			for (String specifytno : specifytnos) {
				if (buffer.indexOf(specifytno) == -1) {
					buffer.append(specifytno).append(",");
				}
			}
			String str = buffer.toString();
			return str;
		} else {
			return null;
		}
	}

	/**
	 * @param @param
	 *            str （ 0110010000 返回 [2, 3, 6] ）
	 * @param @return
	 *            参数说明
	 * @return List<Integer> 返回类型
	 * @throws @Title:
	 *             getIntegerLenth
	 * @Description: TODO
	 * @author chenjiaming
	 */
	public static List<Integer> getIntegerLenth(String str) {
		if (str != null) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < str.length(); i++) {
				if (str.substring(i, i + 1).equals("1")) {
					list.add(i + 1);
				}
			}
			return list;
		} else {
			return null;
		}
	}

	/**
	 * @param @param
	 *            str ()
	 * @param @param
	 *            strs
	 * @param @return
	 *            参数说明
	 * @return String 返回类型
	 * @throws @Title:
	 *             getStrAnalytical
	 * @Description: TODO(解析客户端限制 ， 投标属性限制，)
	 * @author chenjiaming
	 */
	public static String getStrAnalytical(String str, String[] strs) {
		if (str != null && strs.length > 0) {
			List<Integer> list = getIntegerLenth(str);
			StringBuffer buffer = new StringBuffer();
			for (Integer lis : list) {
				if (lis <= strs.length) {
					buffer.append(strs[lis - 1]).append(",");
				}
			}
			String str4 = buffer.toString();
			return str4;
		} else {
			return null;
		}
	}

	/**
	 * 比对会员等级
	 *
	 * @param str
	 * @param str2
	 * @return
	 */
	public static boolean getCompareUGrade(String str, String str2) {
		boolean flag = false;
		if (StringUtil.isNotEmpty(str) && StringUtil.isNotEmpty(str2)) {
			for (int i = 0; i < str.length(); i++) {
				if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(str2.charAt(i)))
						&& String.valueOf(str.charAt(i)).equalsIgnoreCase("1")) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}



	/**
	 * 判断是否包含中文
	 *
	 * @param str
	 * @return
	 */
	public static boolean isChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * @param @param
	 *            Valuedate 截标日期
	 * @param @param
	 *            Valuepoint 截标时间点
	 * @param @param
	 *            Valuerule 起息时间点
	 * @param @return
	 *            参数说明
	 * @return Date 返回类型
	 * @throws @Title:
	 *             getValuedate
	 * @Description: TODO(获取规则比较后的起息日期)
	 * @author cjm
	 */
	public static Date getValuedate(Date Valuedate, String Valuepoint, Short Valuerule) {
		if (Valuedate != null && Valuerule != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(Valuedate);
			if (Valuerule.equals((short) 2)) {// 结标日次日
				calendar.add(Calendar.DATE, 1);
				Valuedate = calendar.getTime();
			} else if (Valuerule.equals((short) 3)) {// 3.结标日固定时间之前(截标日期 时分秒
														// 大于起息日时间点(10:00:00)
														// 截标日加1天 否则算当天 )
				Date str2 = StringUtil.getDateByString(Valuepoint, "HH:mm:ss");
				Date str3 = StringUtil.getDateByString(StringUtil.formatDate(Valuedate, "HH:mm:ss"), "HH:mm:ss");
				if (str3.getTime() > str2.getTime()) {// 小于等于算当天
					calendar.setTime(Valuedate);
					calendar.add(Calendar.DATE, 1);
					Valuedate = calendar.getTime();
				}
			}
			return Valuedate;
		}
		return null;
	}

	/**
	 * 比较年月日主要是(宽限期到期时间后,标的债转设置表中逾期前几天可债转)和当前时间的比较
	 *
	 * @param @param
	 *            a
	 * @param @param
	 *            b
	 * @param @return
	 *            参数说明
	 * @return boolean 返回类型
	 * @throws @Title:
	 *             ComparisonTime
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author jiangxueyou
	 */
	public static boolean ComparisonTime(Date a, Date b) {
		boolean flag = false;
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
		String caltime = sdf3.format(a);
		String[] aTime = caltime.split("-");
		String caltime2 = sdf3.format(b);
		String[] bTime = caltime2.split("-");
		if (Double.valueOf(aTime[0]) < Double.valueOf(bTime[0])) {// 年
			if (Double.valueOf(aTime[1]) < Double.valueOf(bTime[1])) {// 月
				if (Double.valueOf(aTime[2]) < Double.valueOf(bTime[2])) {// 日
					flag = true;
				}
			}
		}
		return flag;

	}


	/**
	 * @param @param
	 * @param @return
	 *            格式为2位随机数加 yyyyMMddHHmmssSSS格式的当前时间
	 * @return String 返回类型
	 * @throws @Title:
	 *             getRandomTimeStamp
	 * @Description: TODO(乾多多 随机时间戳)
	 * @author chenjiaming
	 */
	public static String getRandomTimeStamp() {
		StringBuffer buffer = new StringBuffer();
		String dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		Random random = new Random();
		for (int i = 0; i < 2; i++) {
			buffer.append(Integer.toString(random.nextInt(10)));
		}
		buffer.append(dateFormat);
		String actno = buffer.toString();
		return actno;
	}



	/**
	 * 校验银行卡卡号是否合法
	 *
	 * @param @param
	 *            bankCard
	 * @param @return
	 *            设定文件
	 * @return boolean 返回类型
	 * @throws @Title:
	 *             checkBankCard
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 */
	public static boolean checkBankCard(String bankCard) {
		if (bankCard.length() < 15 || bankCard.length() > 19) {
			return false;
		}
		char bit = getBankCardCheckCode(bankCard.substring(0, bankCard.length() - 1));
		if (bit == 'N') {
			return false;
		}
		System.out.println(bankCard.charAt(bankCard.length() - 1));
		return bankCard.charAt(bankCard.length() - 1) == bit;
	}

	/**
	 * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
	 *
	 * @param nonCheckCodeBankCard
	 * @return char 返回类型
	 * @Title: getBankCardCheckCode
	 * @Description: TODO(从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位)
	 */
	public static char getBankCardCheckCode(String nonCheckCodeBankCard) {
		if (nonCheckCodeBankCard == null || nonCheckCodeBankCard.trim().length() == 0
				|| !nonCheckCodeBankCard.matches("\\d+")) {
			// 如果传的不是数据返回N
			return 'N';
		}
		char[] chs = nonCheckCodeBankCard.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}

	/**
	 * 银行卡显示格式转换
	 *
	 * @author 作者 xiaoy:
	 * @version 创建时间：2017年4月19日 下午12:02:39
	 * @param bankNo
	 * @return
	 */
	public static String formatBankNo(String bankNo) {
		if (StringUtil.isNotEmpty(bankNo)) {
			StringBuilder sb = new StringBuilder(bankNo);
			int length = bankNo.length() / 4 + bankNo.length();
			for (int i = 0; i < length; i++) {
				if (i % 5 == 0) {
					sb.insert(i, " ");
				}
			}
			sb.deleteCharAt(0);
			return sb.toString();
		}
		return null;
	}

	
	// 按指定的字符集构建文件流
	public static String stringStream(InputStream ins, String charset) {
		BufferedReader br;
		StringBuffer sbf = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(ins, charset));
			String line = null;
			try {
				while ((line = br.readLine()) != null) {
					sbf.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sbf.toString();

	}
	
}
