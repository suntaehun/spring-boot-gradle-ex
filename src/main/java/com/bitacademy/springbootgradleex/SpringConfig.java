package com.bitacademy.springbootgradleex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.springbootgradleex.aop.TimeTraceAop;
import com.bitacademy.springbootgradleex.repository.MemberRepository;
import com.bitacademy.springbootgradleex.service.MemberService;

@Configuration
public class SpringConfig {
	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
//	TimeTraceAop에 Component로 대체가능
//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
	
//	@Bean
//	public MemberRepository memberRepository(){
//		return new MemoryMemberRepository();
//		return new JdbcTemplateMemberRepository(dataSource);
//		return new JpaMemberRepository(em);
//	}
}
