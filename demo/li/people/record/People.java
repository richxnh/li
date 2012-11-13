package li.people.record;

import li.annotation.Bean;
import li.annotation.Table;
import li.dao.Record;

@Bean
@Table("t_people")
public class People extends Record<People> {

}