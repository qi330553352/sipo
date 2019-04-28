package com.sz.qzxkj.mapper;

import com.sz.qzxkj.entity.DepartmentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 创 建 时 间: 2019/3/24
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Repository
public interface DepartmentInfoMapper {


    DepartmentInfo findById(@Param("id") Integer id);

    int save(DepartmentInfo bean);
}
