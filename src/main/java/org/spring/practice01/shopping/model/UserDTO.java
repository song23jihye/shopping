package org.spring.practice01.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{//implements UserDetails
    private Integer id; //회원번호
    private String username; //아이디
    private String password; //패스워드
    private String nickname;
//    private String role; //???
//    private List<GrantedAuthority> authorities;

//    @Override
//    public List<GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//    public void setAuthorities(String authority){
//        if(this.authorities == null){
//            this.authorities = new ArrayList<>();
//        }
//        this.authorities.add(new SimpleGrantedAuthority(authority));
//    }

}
