package ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class T {
	public static void main(String[] args) {
		CacheManager cacheManager = CacheManager.create();

		cacheManager.addCacheIfAbsent("name");

		Cache cache = cacheManager.getCache("name");

		Element element = new Element("key", "value");
		cache.put(element);
		cache.remove("key");

		cacheManager.removeCache("name");
	}
}