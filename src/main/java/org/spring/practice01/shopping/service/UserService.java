package org.spring.practice01.shopping.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;
import org.spring.practice01.shopping.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final SqlSession SESSION;
    private final String NAMESPACE="org.spring.practice01.mappers.UserMapper";
    public UserDTO auth(UserDTO attempt){
        return SESSION.selectOne(NAMESPACE+".auth",attempt);
        //sqlSession클래스 selectOne(statement, object)
        //statement = [NAMESPACE + mapper.xml의 id]
    }
//    public boolean validateUsername(String username){
//        SESSION.insert(NAMESPACE+".selectByUsername",username)==null;
//    }
    public UserDTO selectByUsername(String username){
        return SESSION.selectOne(NAMESPACE+".selectByUsername",username);
    }

    public void register(UserDTO userDTO){
        SESSION.insert(NAMESPACE+".insertUser",userDTO);
    }
}
