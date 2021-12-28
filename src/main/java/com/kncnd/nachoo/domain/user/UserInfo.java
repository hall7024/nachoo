package com.kncnd.nachoo.domain.user;

import com.kncnd.nachoo.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserInfo extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPwd;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userAuth;

    @Builder
    public UserInfo(String userId, String userPwd, String userName, String userAuth) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userAuth = userAuth;
    }

    public void update(UserInfo userInfo) {
        this.userPwd = userInfo.userPwd;
        this.userName = userInfo.userName;
        this.userAuth = userInfo.userAuth;
    }
}
