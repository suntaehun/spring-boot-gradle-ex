package com.bitacademy.springbootgradleex.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bitacademy.springbootgradleex.domain.Member;
import com.bitacademy.springbootgradleex.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void 회원가입() throws Exception {
		// Given
		Member member = new Member();
		member.setName("spring");
		// When
		Long saveId = memberService.join(member);
		// Then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	void 중복회원예외() throws Exception {
		//Given
		 Member member1 = new Member();
		 member1.setName("spring");
		 Member member2 = new Member();
		 member2.setName("spring");
		 
		//When
		 memberService.join(member1);
		 IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		 
		 assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		 try {
//			 memberService.join(member2);
//			 fail();
//		 } catch (IllegalStateException e) {
//			 assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//		 }
	}

}
