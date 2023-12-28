package com.example.shop.controller;

import com.example.shop.domain.Member;
import com.example.shop.repository.MemberRepository;
import com.example.shop.service.MemberService;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/member") // 얘는 공통 주소
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/add")
    // 회원가입 폼을 보여주는 메서드
    public String addForm() {
        return "memberForm"; // template/ 하위에서 memberForm.html 이라는 뷰를 찾을 것
    }

    @PostMapping("/add")
    public String add(Member member, Model model) {
        memberService.joinMember(member);

        model.addAttribute("member", member);
        // return "memberView";
        return "redirect:/member/list";
    }

    // 나는 레포지토리에 있는 printMember를 호출하려고 했는데, 아닌듯...
    // 그개 아니라 list 라는 url 에 대해서 memberList.html 을 보여주는 방식으로 해야한다.
    // 오...! 멤버 레포지토리한테 회원 얻어오는 건 맞았다.

    @GetMapping("/list")
    public String showList(Model model) {
        List<Member> memberList = memberService.getMembers();
        // 실제 멤버리스트를 화면에 뿌려주기 위해서 Model 이 필요했던 것이고, members 라는 이름을 가졌고, 실체는 memberList 이다.
        model.addAttribute("members", memberList);
        return "memberList"; // memberList.html 을 찾기
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam String id, Model model) {
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "memberUpdateForm"; // 이런 html 파일을 폼으로 받겠다.
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Member member) { // 전체를 다 받아올거다
        memberService.updateMember(member); // 서비스한테 업데이트 해줘!! 라고 하는 것
        return "redirect:/member/list";
    }

    // 삭제는 GET
    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        memberService.deleteMember(id);
        return "redirect:/member/list";

    }
}

