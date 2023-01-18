package com.bitacademy.springbootgradleex;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.springbootgradleex.repository.JpaMemberRepository;
import com.bitacademy.springbootgradleex.repository.MemberRepository;
import com.bitacademy.springbootgradleex.service.MemberService;

@Configuration
public class SpringConfig {
	
	private EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository(){
//		return new MemoryMemberRepository();
		return new JpaMemberRepository(em);
	}
}
