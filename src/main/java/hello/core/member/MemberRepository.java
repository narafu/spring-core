package hello.core.member;

public interface MemberRepository {

    // DB ์ ์ฅ
    void save(Member member);

    // DB ์กฐํ(id)
    Member findById(Long memberId);

}
