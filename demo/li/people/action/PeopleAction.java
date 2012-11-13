package li.people.action;

import li.annotation.At;
import li.annotation.Bean;
import li.annotation.Inject;
import li.mvc.AbstractAction;
import li.people.record.People;
import li.util.Page;

@Bean
public class PeopleAction extends AbstractAction {
    @Inject
    People peopleDao;

    @At("people_list.do")
    public void list(Page page) {
        setRequest("peoples", peopleDao.list(page)).view("people/list");
    }
}