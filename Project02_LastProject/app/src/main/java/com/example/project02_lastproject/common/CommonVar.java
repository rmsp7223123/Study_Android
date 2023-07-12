package com.example.project02_lastproject.common;

import com.example.project02_lastproject.member.AndMembersVO;

public class CommonVar {
    // 안드로이드는 스프링과 다르게 세션이 없어 static 활용
    public static AndMembersVO loginInfo; // 여기에 로그인이 정상적으로 되면 정보를 저장
}
