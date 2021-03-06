package jyanoos.lol_bottom.service;

import jyanoos.lol_bottom.domain.member.KaKao.KakaoLoginResult;
import jyanoos.lol_bottom.domain.member.KaKao.KakaoToken;
import jyanoos.lol_bottom.domain.member.Member;
import jyanoos.lol_bottom.domain.member.MemberResult;

public interface MemberService {
    MemberResult memberJoin(String userEmail, String userPassword, String userPasswordCheck, String userNickname);
    MemberResult memberLogin(String userEmail, String userPassword);
    Member findMemberByNickname(String userNickName);


    KakaoToken getKakaoAccessToken(String code);

    KakaoLoginResult getKakaoUserInfo(String accessToken);
}
