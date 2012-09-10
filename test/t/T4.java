package t;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import li.dao.Record;
import li.ioc.IocContext;
import li.model.Field;
import li.util.Files;
import li.util.Reflect;
import li.util.Verify;

public class T4 {
	public static void main(String[] args) {
		System.out.println(toJson(IocContext.getInstance().BEANS));
	}

	public static String toJson(Object target) {
		if (target instanceof Collection) {// 如果是集合,转换成数组处理
			return toJson(((Collection<?>) target).toArray());
		}
		if (target.getClass().isArray()) {// 如果是数组
			String json = "[";
			for (Object one : (Object[]) target) {// 处理每个对象
				json += toJson(one) + ",";
			}
			return json.substring(0, json.length() - 1) + "]";// 返回
		}
		// 处理单个对象
		String json = "{";
		if (Record.class.isAssignableFrom(target.getClass())) {// 如果是Record
			for (Entry<String, Object> entry : ((Record<?>) target).entrySet()) {// Record的每个属性
				json += "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",";
			}
		} else {// 不是Record，按照POJO处理
			for (Field field : Field.list(target.getClass(), false)) {// POJO的每个属性
				if ("log" != field.name && "BEAN_MAP" != field.name && "instance" != field.name && "table" != field.name && "id" != field.name) {

					if (Verify.basicType(Reflect.fieldType(target.getClass(), field.name))) {
						json += "\"" + field.name + "\":\"" + Reflect.get(target, field.name) + "\",";
					} else {
						json += "~~";
					}
				}
			}
		}
		return json.substring(0, json.length() - 1) + "}";
	}

	public static void main2(String[] args) {
		String regex = "^.*\\\\WEB-INF\\\\lib\\\\.*.jar$";
		List<String> list = Files.list(new File(System.getProperty("user.dir")), regex, true);
		for (String string : list) {
			System.out.println(string);
		}
	}
}