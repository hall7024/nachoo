package com.kncnd.nachoo.web.dto;

import com.kncnd.nachoo.domain.user.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoDto {

    private String userId;
    private String userPwd;
    private String userName;
    private String userAuth;

    @Builder
    public UserInfoDto(UserInfo userInfo) {
        this.userId = userInfo.getUserId();
        this.userPwd = userInfo.getUserPwd();
        this.userName = userInfo.getUserName();
        this.userAuth = userInfo.getUserAuth();
    }

    public UserInfo toEntity() {
        return UserInfo.builder()
                .userId(userId)
                .userPwd(userPwd)
                .userName(userName)
                .userAuth(userAuth).build();
    }
}
