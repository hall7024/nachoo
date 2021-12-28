package com.kncnd.nachoo.web.api;

import com.kncnd.nachoo.service.UserInfoService;
import com.kncnd.nachoo.web.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/userinfo")
public class UserApiController {

    private final UserInfoService userInfoService;

    @PostMapping("/save")
    public String save(@RequestBody UserInfoDto dto) throws Exception {
        return userInfoService.save(dto);
    }

    @PutMapping("/update")
    public void update(@RequestBody UserInfoDto dto) throws Exception {
        userInfoService.update(dto);
    }

}
