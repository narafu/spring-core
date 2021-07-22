package hello.core.member;

public interface MemberRepository {

    // DB 저장
    void save(Member member);

    // DB 조회(id)
    Member findById(Long memberId);

}
