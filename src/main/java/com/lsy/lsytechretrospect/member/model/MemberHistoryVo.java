package com.lsy.lsytechretrospect.member.model;

import lombok.Data;

@Data
public class MemberHistoryVo {
    // 회원 이력
    private String historyId;
    private String memberId;
    private String activityType;
    private String activityDate;
}
