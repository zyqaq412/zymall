package com.hzy.zymall.member.dao;

import com.hzy.zymall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zxwyhzy
 * @email zxwyhzy@gmail.com
 * @date 2023-11-13 16:51:38
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
