package li.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import li.util.Files;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;

public class DruidAdapter extends DruidDataSource {
    private static final long serialVersionUID = 8840084696561752691L;

    private static Properties properties = Files.load("config.properties");

    // 禁止使用的func列表
    private static String[] PERMIT_FUNCTIONS = properties.getProperty("DRUID.PERMIT_FUNCTIONS").split(",");
    // 禁止访问的数据库列表
    private static String[] PERMIT_SCHEMAS = properties.getProperty("DRUID.PERMIT_SCHEMAS").split(",");
    // 禁止访问的table列表
    private static String[] PERMIT_TABLES = properties.getProperty("DRUID.PERMIT_TABLES").split(",");
    // 只读table列表
    private static String[] READONLY_TABLES = properties.getProperty("DRUID.READONLY_TABLES").split(",");
    // 禁止访问的系统对象列表
    private static String[] PERMIT_OBJECTS = properties.getProperty("DRUID.PERMIT_OBJECTS").split(",");
    //
    private static String[] PERMIT_VARIANTS = properties.getProperty("DRUID.PERMIT_VARIANTS").split(",");

    /**
     * 初始化方法
     */
    public DruidAdapter() {
        WallConfig wallConfig = loadWallConfig();
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(wallFilter);

        super.setProxyFilters(filters);
    }

    /**
     * 加载WallConfig配置
     */
    private WallConfig loadWallConfig() {
        WallConfig wallConfig = new WallConfig();

        wallConfig.getPermitFunctions().addAll(Arrays.asList(PERMIT_FUNCTIONS));
        wallConfig.getPermitObjects().addAll(Arrays.asList(PERMIT_OBJECTS));
        wallConfig.getPermitSchemas().addAll(Arrays.asList(PERMIT_SCHEMAS));
        wallConfig.getPermitTables().addAll(Arrays.asList(PERMIT_TABLES));
        wallConfig.getPermitVariants().addAll(Arrays.asList(PERMIT_VARIANTS));
        wallConfig.getReadOnlyTables().addAll(Arrays.asList(READONLY_TABLES));

        return wallConfig;
    }
}