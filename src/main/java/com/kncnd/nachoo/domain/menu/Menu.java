package com.kncnd.nachoo.domain.menu;

import com.kncnd.nachoo.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Menu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuSeq;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private String menuUrl;

    @Column(nullable = false)
    private String menuAuth;

    @Builder
    public Menu(String menuName, String menuUrl, String menuAuth) {
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.menuAuth = menuAuth;
    }

    public void update(Menu menu) {
        this.menuName = menu.menuName;
        this.menuUrl = menu.menuUrl;
        this.menuAuth = menu.menuAuth;
    }
}
