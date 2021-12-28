package com.kncnd.nachoo.domain.menu;

import com.kncnd.nachoo.domain.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<UserInfo, Long> {
}
