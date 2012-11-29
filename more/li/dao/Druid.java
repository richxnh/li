package li.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;

public class Druid extends DruidDataSource {
    private static final long serialVersionUID = 8840084696561752691L;

    // 禁止使用的func列表
    private static final String[] PERMIT_FUNCTIONS = {};

    // 禁止访问的数据库列表
    private static final String[] PERMIT_SCHEMAS = {};

    // 禁止访问的table列表
    private static final String[] PERMIT_TABLES = {};

    // 只读table列表
    private static final String[] READONLY_TABLES = {};

    // 禁止访问的系统对象列表
    private static final String[] PERMIT_OBJECTS = {};

    //
    private static final String[] PERMIT_VARIANTS = {};

    /**
     * 初始化方法
     */
    public Druid() {
        WallConfig wallConfig = loadWallConfig();
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(wallFilter);

        super.setProxyFilters(filters);
    }

    /**
     * 加在WallConfig配置
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