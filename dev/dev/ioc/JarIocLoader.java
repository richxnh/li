package dev.ioc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.xpath.XPathConstants;

import li.annotation.Inject;
import li.model.Bean;
import li.util.Files;
import li.util.Log;
import li.util.Reflect;

import org.w3c.dom.NodeList;

public class JarIocLoader {
	private static final Log log = Log.init();

	public Collection<? extends Bean> getBeans() {

		String XML_REGEX = "^.*.xml$";
		log.info(String.format("Searching for Xml files,at %s", Files.root()));
		List<Bean> beans = new ArrayList<Bean>();
		for (String filePath : Files.list(Files.root(), XML_REGEX, true)) {
			NodeList beanNodes = (NodeList) Files.xpath(Files.build(filePath), "//jar", XPathConstants.NODESET);
			for (Integer i = 0; null != beanNodes && i < beanNodes.getLength(); i++) {
				String typeName = (String) Files.xpath(beanNodes.item(i), "@class", XPathConstants.STRING);
				String path = Reflect.getType(typeName).getResource("").getPath();

				System.out.println(path);
				path = path.split("file:/")[1].split("!")[0];

				ZipFile zipFile = null;
				try {
					zipFile = new ZipFile(path);
					System.out.println(path);
				} catch (IOException e) {
					e.printStackTrace();
				}

				Enumeration<? extends ZipEntry> entries = zipFile.entries();
				while (entries.hasMoreElements()) {
					ZipEntry zipEntry = (ZipEntry) entries.nextElement();
					if (zipEntry.getName().endsWith(".class")) {
						String className = zipEntry.getName().replace("/", ".").replace(".class", "");
						Class<?> type = Reflect.getType(className);
						li.annotation.Bean beanAnnotation = (li.annotation.Bean) type.getAnnotation(li.annotation.Bean.class);
						if (beanAnnotation != null) {
							li.model.Bean iocBean = new li.model.Bean();
							iocBean.type = type;
							iocBean.name = beanAnnotation.value();

							for (java.lang.reflect.Field field : type.getDeclaredFields()) {
								Inject inject = field.getAnnotation(Inject.class);
								if (null != inject) {
									li.model.Field attribute = new li.model.Field();
									attribute.name = field.getName();
									attribute.type = field.getType();
									attribute.value = inject.value();
									iocBean.fields.add(attribute);
								}
							}

							beans.add(iocBean);

							log.info(String.format("ADD BEAN: @Bean in jar %s %s", type.getName(), iocBean.name));
						}
					}

				}
			}
		}
		return beans;
	}
}
