package com.sz.qzxkj.mapper;

import com.sz.qzxkj.entity.PatentLifeInfo;
import org.springframework.stereotype.Repository;

/**
 * 创 建 时 间: 2019/3/22
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Repository
public interface PatentLifeInfoMapper {

    int save(PatentLifeInfo bean);
}
