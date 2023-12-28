package com.example.shop.repository;

// 데이터를 저장할 레포지토리 저장소

import com.example.shop.domain.Member;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

// 데아터베이스와의 상호작용

@Repository
public class MemberRepository {
    private static HashMap<String, Member> memberRepo = null;

    // 생성자
    public MemberRepository() {
        memberRepo = new HashMap<>();
        // 두개의 멤버를 넣어줌 (테스트를 위해)
        Member kang = new Member("강풀", "kang", "1234", "kang@naver.com", "010-1234-5678");
        Member kim = new Member("김둘리", "kim", "1234", "kim@naver.com", "010-11111-2222");
        // 멤버를 map 에 넣어준다.?
        memberRepo.put(kang.getId(), kang);
        memberRepo.put(kim.getId(), kim);

    }

    // 간단히 콘솔에 해시맵을 출력하는 용도
    private void printMembers() {
        memberRepo.forEach((key, value)-> {
            System.out.println(key + ":::" + value);
        });

    }

    public void saveMember(Member member) {
        memberRepo.put(member.getId(), member);
        printMembers();
    }


    public List<Member> getMembers() {
        return memberRepo.values().stream().toList();
    }

    public Member getMember(String id) {
        // 맵한테 id 라는 key 에 대한 value 값인 member 를 얻어오도록
        return memberRepo.get(id);
    }

    public void updateMember(Member member) {
        memberRepo.put(member.getId(), member);
    }

    public void deleteMember(String id) {
        memberRepo.remove(id);
    }
}
