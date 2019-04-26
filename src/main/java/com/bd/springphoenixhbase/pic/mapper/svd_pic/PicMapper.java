package com.bd.springphoenixhbase.pic.mapper.svd_pic;

import com.bd.springphoenixhbase.config.annotation.Mapper;
import com.bd.springphoenixhbase.pic.model.svd_pic.Pic;

import java.util.List;

@Mapper
public interface PicMapper {
    int deleteByPrimaryKey(String id);

    int insert(Pic record);

    int insertSelective(Pic record);

    Pic selectByPrimaryKey(String id);

    List<Pic> selectAll();
}