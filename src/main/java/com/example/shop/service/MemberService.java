package com.example.shop.service;

import com.example.shop.domain.Member;
import com.example.shop.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void joinMember(Member member) {
        // 처리할 모든 비즈니스는 여기서 진행
        memberRepository.saveMember(member);
    }

    // 저장된 모든 멤버 목록을 리스트로 반환하는 기능
    public List<Member> getMembers() {
        return memberRepository.getMembers();
    }

    public Member getMember(String id) {
        return memberRepository.getMember(id);
    }

    public void updateMember(Member member) { // 뭘 수정할건지를 갖고 들어와야하니까 member
        memberRepository.updateMember(member);
    }

    public void deleteMember(String id) {
        memberRepository.deleteMember(id);
    }

}
