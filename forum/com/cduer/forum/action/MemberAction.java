package com.cduer.forum.action;

import li.annotation.At;
import li.annotation.Bean;
import li.annotation.Inject;
import li.mvc.AbstractAction;

import com.cduer.forum.record.Account;
import com.cduer.forum.record.Member;

@Bean
public class MemberAction extends AbstractAction {
	@Inject
	Member memberDao;

	@At("member")
	public void find(Integer id) {
		Member member = memberDao.find(id);
		Account account = (Account) getSession("account");
		if (null != member && null != account && member.get("account_id").equals(account.get("id"))) {
			setRequest("member", member);
			view("WEB-INF/view/member_show.jsp");
		} else {
			write("你没登陆");
		}
	}
}