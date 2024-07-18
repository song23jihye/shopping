package org.spring.practice01.shopping.service;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.spring.practice01.shopping.model.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReplyService{
    private final String NAMESPACE = "org.spring.practice01.mappers.ReplyMapper";

    @Autowired
    public SqlSession SESSION;

    public List<ReplyDTO> showAll(int goodsId){
        return SESSION.selectList(NAMESPACE+".selectAll",goodsId);
    }
    public ReplyDTO showOne(int replyid){
        return SESSION.selectOne(NAMESPACE+".selectOne",replyid);
    }
    public void insert(ReplyDTO replyDTO){
        SESSION.insert(NAMESPACE+".insert",replyDTO);
    }


}
