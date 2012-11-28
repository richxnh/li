package demo;

import li.ioc.Ioc;

import com.alibaba.druid.pool.DruidDataSource;

public class T {
    public static void main(String[] args) throws Exception {
        DruidDataSource druidDataSource = Ioc.get(DruidDataSource.class);

        System.out.println(druidDataSource.getConnection());
    }
}