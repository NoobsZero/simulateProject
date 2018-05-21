package com.smg.taskplatform.task.controller;

import com.magicube.framework.common.base.BaseController;
import com.magicube.framework.upms.dao.model.UpmsUser;
import com.smg.taskplatform.task.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 任务controller
 *
 * @author justincai
 */
@Controller
@Api(value = "任务管理")
@RequestMapping("/manage/task")
public class TaskController extends BaseController {

    private static final Log log = LogFactory.getLog(TaskController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "选择联系人")
    @RequestMapping(value = "/personselect", method = RequestMethod.GET)
    public String personselect(ModelMap modelMap) {

        List<UpmsUser> userList = userService.getAllUsersExceptAdmin();
        modelMap.put("userList", userList);

        return "/manage/task/personselect.jsp";
    }

}
