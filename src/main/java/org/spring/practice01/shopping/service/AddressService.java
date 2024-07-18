package org.spring.practice01.shopping.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.spring.practice01.shopping.model.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    @Autowired
    private final SqlSession SESSION;
    private final String NAMESPACE="org.spring.practice01.mappers.AddressMapper";

    public List<AddressDTO> pickOneAddress(int id){
        return SESSION.selectList(NAMESPACE+".pickOneAddress",id);
    }
}
