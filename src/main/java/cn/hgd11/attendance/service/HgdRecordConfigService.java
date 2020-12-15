package cn.hgd11.attendance.service;

import cn.hgd11.common.entity.ObjectResultResponse;
import cn.hgd11.common.util.BooleanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.hgd11.attendance.model.HgdRecordConfig;
import cn.hgd11.attendance.mapper.HgdRecordConfigMapper;
import cn.hgd11.tk.mybatis.biz.BusinessBiz;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author 尚村山夫
 * @version 2020-12-15 23:50:07
 * @email
 */
@Service
public class HgdRecordConfigService extends BusinessBiz<HgdRecordConfigMapper, HgdRecordConfig> {
    public ObjectResultResponse<HgdRecordConfig> recordConfig(HgdRecordConfig hgdRecordConfig) {
        /*
         * 1 -> 查询是否已经配置了有效打卡记录，该记录在数据库中只能有一条
         * 2 -> 如果已经进行配置，则进行更新操作，否则进行新增操作
         *      在进行属性复制操作时，并没有使用org.springframework.beans.BeanUtils.copyProperties(java.lang.Object, java.lang.Object)
         *      提供的方法，BeanUtils采用代理模式，其性能不及setter方法
         */
        Example example = new Example(HgdRecordConfig.class);
        example.createCriteria().andEqualTo("delete_flag", BooleanUtils.FALSE);
        Optional<HgdRecordConfig> configedOptional = Optional.ofNullable(this.mapper.selectOneByExample(example));
        if (configedOptional.isPresent()) {
            // 进行更新操作
            HgdRecordConfig configed = configedOptional.get();
            if (hgdRecordConfig.getAmEnd() != null) {
                configed.setAmEnd(hgdRecordConfig.getAmEnd());
            }
            if (hgdRecordConfig.getAmStart() != null) {
                configed.setAmStart(hgdRecordConfig.getAmStart());
            }
            if (hgdRecordConfig.getPmEnd() != null) {
                configed.setPmEnd(hgdRecordConfig.getPmEnd());
            }
            if (hgdRecordConfig.getPmStart() != null) {
                configed.setPmStart(hgdRecordConfig.getPmStart());
            }
            configed.setUpdTime(new Date());
            this.mapper.updateByPrimaryKeySelective(configed);
            hgdRecordConfig.setId(configed.getId());
        } else {
            // 进行新增操作
            Date date = new Date();
            hgdRecordConfig.setCrtTime(date);
            hgdRecordConfig.setUpdTime(date);
            this.mapper.insertSelective(hgdRecordConfig);
        }

        return new ObjectResultResponse<>("更新完成", 0, hgdRecordConfig);
    }
}