package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        /**
         * ApplicationContext : 스프링 컨테이너
         * @Configuration이 붙은 클래스를 설정 정보로 사용
         * @Bean이 붙은 메서드 명을 스프링 빈 이름으로 사용
         * 스프링 빈을 가져올 때는 .getBean(스프링 빈 이름, 해당 클래스)
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
