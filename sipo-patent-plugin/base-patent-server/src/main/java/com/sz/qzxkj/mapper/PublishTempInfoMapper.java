package com.sz.qzxkj.mapper;

import com.sz.qzxkj.entity.PublishTempInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创 建 时 间: 2019/3/21
 * 版       本: V1.0
 * 作       者: qixin
 * 版 权 所 有: 版权所有(C)2019-2029
 * 公       司: 七智星科技有限公司
 */
@Repository
public interface PublishTempInfoMapper {

    int save(PublishTempInfo bean);

    List<PublishTempInfo> findFullInfo();

}
