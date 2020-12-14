package cn.hgd11.attendance.controller;

import cn.hgd11.tk.mybatis.controller.BaseController;
import cn.hgd11.attendance.service.HgdUserService;
import cn.hgd11.attendance.model.HgdUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 尚村山夫
 * @version 2020-12-14 21:14:31
 * @email
 */
@RestController
@RequestMapping("hgdUser")
public class HgdUserController extends BaseController<HgdUserService, HgdUser, Integer> {

}