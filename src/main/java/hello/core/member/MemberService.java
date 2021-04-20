package hello.core.member;

public interface MemberService {

    Long join(Member member);
    Member findMember(Long memberID);
}
