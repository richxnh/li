package li.util;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import li.ioc.Ioc;
import li.model.Bean;
import li.model.Field;

/**
 * 类型转换的工具类
 * 
 * @author li (limw@w.cn)
 * @version 0.1.7 (2012-05-08)
 */
public class Convert2 {
	/**
	 * 把Json里面的数据转换一个type类型的对象的List
	 * 
	 * @see li.util.Convert#toJson(Object)
	 */
	public static <T> List<T> fromJson(Class<T> type, String json) {
		final String JSON_REGEX = "^.*}[]]{0,1},[\\[]{0,1}\\{.*$", JSON_SPLIT = "}[]]{0,1},[\\[]{0,1}\\{";
		List<T> list = new ArrayList<T>();
		if (Verify.regex(json, JSON_REGEX)) {
			for (String js : json.split(JSON_SPLIT)) {
				list.addAll(fromJson(type, js)); // 这里递归调用
			}
			return (List<T>) list;
		}

		T t = Reflect.born(type);
		for (Field field : Bean.getMeta(Ioc.get(DataSource.class), type).fields) {// 支持Record但不支持多数据源
			int start = json.indexOf(field.name) + field.name.length() + 3;
			int end = start + json.substring(start).indexOf("\"");
			String value = json.substring(start, end);
			if (start > 4 && end - start > 0 && !"NULL".equals(value.trim().toUpperCase())) {
				Reflect.set(t, field.name, value);// 存在这个属性并不为空字符串且不为null
			}
		}
		list.add(t);
		return list;
	}

	/**
	 * 把一个对象或对象的Collection转换为Json
	 * 
	 * @see li.util.Convert#fromJson(Class, String)
	 */
	public static String toJson(Object object) {
		if (object instanceof Collection) { // 解析一个List
			String json = "[";
			for (Object obj : (Collection<?>) object) {
				json += toJson(obj) + ","; // 这里递归调用
			}
			return json.substring(0, json.length() - 1) + "]";
		}

		String json = "{"; // 解析一个对象
		for (Field field : Bean.getMeta(Ioc.get(DataSource.class), object.getClass()).fields) {// 支持Record但不支持多数据源
			json += "\"" + field.column + "\":\"" + Reflect.get(object, field.name) + "\",";
		}
		return json.substring(0, json.length() - 1) + "}";
	}

	/**
	 * 将数组转换为Map，奇数位为key，偶数位为value;item必须为偶数个
	 */
	public static Map<?, ?> toMap(Object... items) {
		Map<Object, Object> map = new HashMap();
		if (null != items && items.length > 0) {// 非空判断
			if (items.length % 2 != 0) {
				throw new RuntimeException("Count of items must be even !!!");// 个数为奇数，抛出异常
			} else {
				for (int i = 0; i < items.length; i = i + 2) {
					map.put(items[i], items[i + 1]);
				}
			}
		}
		return map;
	}

	/**
	 * 把字符串用一次MD5加密后返回
	 */
	public static String toMD5(Object input) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(input.toString().getBytes());
			byte[] byteDigest = messageDigest.digest();
			StringBuffer stringBuffer = new StringBuffer("");
			int i;
			for (int offset = 0; offset < byteDigest.length; offset++) {
				i = byteDigest[offset] < 0 ? byteDigest[offset] + 256 : byteDigest[offset];
				if (i < 16) {
					stringBuffer.append("0");
				}
				stringBuffer.append(Integer.toHexString(i));
			}
			return stringBuffer.toString(); // 32位加密
		} catch (Exception e) {
			throw new RuntimeException("Exception at li.util.Convert.toMD5(Object)", e);
		}
	}

	/**
	 * 把传入的value转换为type类型
	 */
	public static <T> T toType(Class<T> type, Object value) {
		if ((null != type && null != value) && ((type.equals(Integer.TYPE)) || (type.equals(Integer.class)))) { // 两参数均不为空，且type为Integer类型
			return (T) Integer.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Boolean.TYPE)) || (type.equals(Boolean.class)))) {
			return (T) Boolean.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Long.TYPE)) || (type.equals(Long.class)))) {
			return (T) Long.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Float.TYPE)) || (type.equals(Float.class)))) {
			return (T) Float.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Double.TYPE)) || (type.equals(Double.class)))) {
			return (T) Double.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Short.TYPE)) || (type.equals(Short.class)))) {
			return (T) Short.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Byte.TYPE)) || (type.equals(Byte.class)))) {
			return (T) Byte.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && ((type.equals(Character.TYPE)) || (type.equals(Character.class)))) {
			return (T) Character.valueOf(value.toString().charAt(0));
		} else if ((null != type && null != value) && (type.equals(java.util.Date.class))) {
			return (T) java.sql.Date.valueOf(value.toString().trim());// *****这里也许有更好的处理方式
		} else if ((null != type && null != value) && (type.equals(java.sql.Date.class))) {
			return (T) java.sql.Date.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && (type.equals(java.sql.Time.class))) {
			return (T) java.sql.Time.valueOf(value.toString().trim());
		} else if ((null != type && null != value) && (type.equals(java.sql.Timestamp.class))) {
			return (T) java.sql.Timestamp.valueOf(value.toString().trim());
		} else {
			return (T) value;
		}
	}

	/**
	 * 将数组中的每个元素进行类型转换
	 * 
	 * @param type type不能是基本数据类型 Primitive
	 */
	public static <T> T[] toType(Class<T> type, Object[] value) {
		T[] dest = null;
		if (null != type && null != value && value.length > 0) {// 参数不为空且数组大小不为0
			if (type == Integer.TYPE) {
				type = (Class<T>) Integer.class;// 将原始数据类型转换为其封装类型
			} else if (type == Boolean.TYPE) {
				type = (Class<T>) Boolean.class;
			} else if (type == Long.TYPE) {
				type = (Class<T>) Long.class;
			} else if (type == Float.TYPE) {
				type = (Class<T>) Float.class;
			} else if (type == Double.TYPE) {
				type = (Class<T>) Double.class;
			} else if (type == Short.TYPE) {
				type = (Class<T>) Short.class;
			} else if (type == Byte.TYPE) {
				type = (Class<T>) Byte.class;
			} else if (type == Character.TYPE) {
				type = (Class<T>) Character.class;
			}
			dest = (T[]) Array.newInstance(type, value.length);// 生成目标类型数组
			for (int i = 0; i < value.length; i++) {
				dest[i] = (T) toType(type, value[i]);// 类型转换每一个元素
			}
		}
		return dest;
	}
}