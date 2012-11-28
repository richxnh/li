package demo;

import li.dao._User;
import li.ioc.Ioc;

public class T {
    public static void main(String[] args) throws Exception {
        _User userDao = Ioc.get(_User.class);
        System.out.println(userDao.query(null, "select version()"));
    }
}