package com.sz.qzxkj.mapper;

import com.sz.qzxkj.entity.Wgsjzlqsy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创 建 时 间: 2019/4/5
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Repository
public interface WgsjzlqsyMapper {

    int save(Wgsjzlqsy bean);

    List<Wgsjzlqsy> findAll();

    int updateById(Wgsjzlqsy bean);
}
