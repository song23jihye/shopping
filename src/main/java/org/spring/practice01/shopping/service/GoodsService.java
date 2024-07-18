package org.spring.practice01.shopping.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.spring.practice01.shopping.model.GoodsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {
    @Autowired
    private final SqlSession SESSION;
    private final String NAMESPACE="org.spring.practice01.mappers.GoodsMapper";

    public GoodsDTO pickOne(int goodsNo){
        return SESSION.selectOne(NAMESPACE+".pickOne",goodsNo);
    }
    public int getEAofGoods(){
        List tmp = SESSION.selectList(NAMESPACE+".totalEA");
        return tmp.size();
    }
    public List<GoodsDTO> pickAll(){
        return SESSION.selectList(NAMESPACE+".pickAll");
    }
}
