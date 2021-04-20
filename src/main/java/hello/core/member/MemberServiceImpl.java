package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // 스프링에서 MemberRepository 타입에 맞는 빈을 찾아서 주입하게 된다.(todo : 충동의 경우에는?)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(Member member) {
        memberRepository.save(member);
        return null;
    }

    @Override
    public Optional<Member> findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }


    //테스트 용도(인터페이스 오버라이드X)
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
