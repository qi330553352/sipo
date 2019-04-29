package com.sz.qzxkj.repository;

import com.sz.qzxkj.entity.DepartmentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * 创 建 时 间: 2019/4/29
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 */
@Repository
public interface DepartmentInfoRepository extends PagingAndSortingRepository<DepartmentInfo,Integer> {

    Page<DepartmentInfo> findByParentId(Integer parentId, Pageable pageable) throws Exception;
}
