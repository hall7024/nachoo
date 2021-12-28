package com.kncnd.nachoo.service;

import com.kncnd.nachoo.domain.user.UserInfo;
import com.kncnd.nachoo.domain.user.UserInfoRepository;
import com.kncnd.nachoo.web.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserInfoService {

    private final UserInfoRepository repository;

    @Transactional
    public String save(UserInfoDto dto) {
        return repository.save(dto.toEntity()).getUserId();
    }

    @Transactional
    public void update(UserInfoDto dto) {
        UserInfo userInfo = repository.findByUserId(dto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("회원 정보가 없습니다. id=" + dto.getUserId())
        );

        userInfo.update(dto.toEntity());
    }

    public UserInfoDto findByUserId(String id) {
        UserInfo userInfo = repository.findByUserId(id).orElseThrow(
                () -> new IllegalArgumentException("회원 정보가 없습니다. id=" + id)
        );

        return new UserInfoDto(userInfo);
    }

}
