package com.lsy.lsytechretrospect.member.service.impl;

import com.lsy.lsytechretrospect.member.mapper.MemberMapper;
import com.lsy.lsytechretrospect.member.model.MemberVo;
import com.lsy.lsytechretrospect.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lsy.lsytechretrospect.common.utils.ValidationUtil.invokeErrors;


@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    public final MemberMapper memberMapper;

    @Override
    public ResponseEntity insertMember(MemberVo memberVo, BindingResult br) throws Exception {
        // validation check
        if(br.hasErrors()) {
            invokeErrors(this.getClass().getName(), br);
        }

        Map<String, Object> returnMap = new HashMap<String, Object>();

        int result = memberMapper.insertMember(memberVo);

        returnMap.put("result", result > 0 ? "success" : "fail");
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity selectMemberById(String memberId) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        MemberVo memberVo = memberMapper.selectMemberById(memberId);
        if(memberVo != null) {
            returnMap.put("memberInfo", memberVo);
        }
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity selectAllMembers() throws Exception {

        Map<String, Object> returnMap = new HashMap<String, Object>();

        List<MemberVo> memberList = memberMapper.selectAllMembers();

        if(memberList != null && !memberList.isEmpty()) {
            returnMap.put("list", memberList);
            returnMap.put("totalCount", memberList.size());
        }

        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateMember(MemberVo memberVo, BindingResult br) throws Exception {
        int result = memberMapper.updateMember(memberVo);
        Map<String, Object> returnMap = new HashMap<String, Object>();

        returnMap.put("result", result > 0 ? "success" : "fail");
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteMember(String memberId) throws Exception {
        int result = memberMapper.deleteMember(memberId);
        Map<String, Object> returnMap = new HashMap<String, Object>();

        returnMap.put("result", result > 0 ? "success" : "fail");
        return new ResponseEntity<>(returnMap, HttpStatus.OK);
    }
}
