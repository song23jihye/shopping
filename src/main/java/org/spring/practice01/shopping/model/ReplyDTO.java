package org.spring.practice01.shopping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Integer id;
    private Integer parentRepId;
    private String content;
    private Date entryDate;
    private Date modifyDate;
    private Integer goodsId;
    private Integer writerId;
    private String writerNickname;
}
