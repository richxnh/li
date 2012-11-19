package li.people.action;

import li.annotation.At;
import li.annotation.Bean;
import li.mvc.AbstractAction;

@Bean
public class IndexAction extends AbstractAction {

    @At("index.do")
    public void index() {
        view("index");
    }

    @At("top.do")
    public void top() {
        view("top");
    }

    @At("left.do")
    public void left() {
        view("left");
    }

    @At("right.do")
    public void right() {
        view("right");
    }
}