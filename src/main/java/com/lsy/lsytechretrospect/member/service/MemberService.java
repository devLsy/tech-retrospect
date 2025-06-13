package com.lsy.lsytechretrospect.member.service;

import com.lsy.lsytechretrospect.member.model.MemberVo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MemberService {

    public ResponseEntity insertMember(MemberVo memberVo, BindingResult br) throws Exception;
    public ResponseEntity selectMemberById(String memberId) throws Exception;
    public ResponseEntity selectAllMembers() throws Exception;
    public ResponseEntity updateMember(MemberVo memberVo, BindingResult br) throws Exception;
    public ResponseEntity deleteMember(String memberId) throws Exception;
}
