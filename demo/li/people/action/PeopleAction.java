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

    @At(value = "people_list.do", method = GET)
    public void list(Page page) {
        setRequest("list", peopleDao.list(page));
        setRequest("page", page);
        view("people/list");
    }
}