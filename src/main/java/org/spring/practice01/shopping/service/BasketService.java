package org.spring.practice01.shopping.service;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.spring.practice01.shopping.model.BasketDTO;
import org.spring.practice01.shopping.model.GoodsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BasketService {
    @Autowired
    private final SqlSession SESSION;
    private final String NAMESPACE="org.spring.practice01.mappers.BasketMapper";

    public List<BasketDTO> pickOneBasket(int id){
        return SESSION.selectList(NAMESPACE+".pickOneBasket",id);
    }
    public List<Integer> goodsInMyBasket(int cusid){
        return SESSION.selectList(NAMESPACE+".goodsNumSearch",cusid);
    }
    public void insertNew(Map<String, Object> param){ // 장바구니에 없던 상품 추가
        SESSION.insert(NAMESPACE+".insert1_newItem",param);
    }
    public void insertOld(Map<String, Object> param){// 장바구니에 있던 상품 추가
        SESSION.update(NAMESPACE+".insert2_oldItem",param);
    }
}
