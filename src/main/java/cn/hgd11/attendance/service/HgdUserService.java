package cn.hgd11.attendance.service;

import org.springframework.stereotype.Service;

import cn.hgd11.attendance.model.HgdUser;
import cn.hgd11.attendance.mapper.HgdUserMapper;
import cn.hgd11.tk.mybatis.biz.BusinessBiz;

/**
 *
 * 
 *
 * @author 尚村山夫
 * @email 
 * @version 2020-12-14 21:14:31
 */
@Service
public class HgdUserService extends BusinessBiz<HgdUserMapper,HgdUser> {
}