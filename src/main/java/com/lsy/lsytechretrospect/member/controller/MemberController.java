package com.lsy.lsytechretrospect.member.controller;

import com.lsy.lsytechretrospect.member.model.MemberVo;
import com.lsy.lsytechretrospect.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity insertBanner(@Valid @RequestBody MemberVo memberVo, BindingResult br) throws Exception {
        return memberService.insertMember(memberVo, br);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberVo> selectMemberById(@PathVariable(name = "memberId") String memberId) throws Exception {
        return memberService.selectMemberById(memberId);
    }

    @GetMapping
    public ResponseEntity<MemberVo> selectAllMembers() throws Exception {
        return memberService.selectAllMembers();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMemberById(@PathVariable(name = "memberId") String memberId) throws Exception {
        return memberService.deleteMember(memberId);
    }
}
