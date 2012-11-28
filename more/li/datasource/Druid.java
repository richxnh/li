package li.datasource;

import com.alibaba.druid.pool.DruidDataSource;

public class Druid extends DruidDataSource {
    private static final long serialVersionUID = 3828995306798592934L;

    public Druid() throws Exception {
        super();
        super.init();
        super.setFilters("wall");
    }
}