package com.sz.qzxkj.repository;

import com.sz.qzxkj.entity.PatentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 创 建 时 间: 2019/4/28
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Repository
public interface PatentInfoRepository extends JpaRepository<PatentInfo,Integer> {


}
