package com.smg.taskplatform.task.operator;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.magicube.framework.common.utils.DateFormatUtil;
import com.magicube.framework.common.validator.LengthValidator;
import com.smg.taskplatform.task.constant.TaskConstant;
import com.smg.taskplatform.task.dao.model.TpTaskChild;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * 任务的相关操作
 *
 * @author justincai
 */
public class TaskOperator {

    private static final Log log = LogFactory.getLog(TaskOperator.class);

    @Autowired
    private UserOperator userOperator;

    public UserOperator getUserOperator() {
        return userOperator;
    }

    public void setUserOperator(UserOperator userOperator) {
        this.userOperator = userOperator;
    }

    /**
     * 检查各字段长度
     *
     * @param taskchild
     * @return
     */
    public ComplexResult checkFieldLength(TpTaskChild taskchild) {

        ComplexResult result = null;

        //检查各字段长度
        //任务描述
        if (!StringUtils.isEmpty(taskchild.getDescription())) {
            log.info("checking field length: description");
            result = FluentValidator.checkAll()
                    .on(taskchild.getDescription(), new LengthValidator(1, 2500, "任务描述"))
                    .doValidate()
                    .result(ResultCollectors.toComplex());

        } else if (!StringUtils.isEmpty(taskchild.getExecutor())) {      //执行人
            log.info("checking field length: executor");
            result = FluentValidator.checkAll()
                    .on(taskchild.getExecutor(), new LengthValidator(1, 500, "执行人"))
                    .doValidate()
                    .result(ResultCollectors.toComplex());

        } else if (!StringUtils.isEmpty(taskchild.getCc())) {      //抄送人
            log.info("checking field length: cc");
            result = FluentValidator.checkAll()
                    .on(taskchild.getCc(), new LengthValidator(1, 1000, "抄送人"))
                    .doValidate()
                    .result(ResultCollectors.toComplex());

        }

        return result;
    }

    /**
     * 检查开始日期与截止日期的合理性（截止日期不能早于开始日期）
     *
     * @param taskchild
     * @return false - 截止日期早于开始日期
     */
    public boolean checkStartAndEndTime(TpTaskChild taskchild) {
        String startTime = taskchild.getShowStarttime();
        String endTime = taskchild.getShowEndtime();
        log.info("startTime:" + startTime + " ; endTime:" + endTime);
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            log.info("startTime and endTime both have value.");
            Date startTimeDate = DateFormatUtil.getDateByStringDate(startTime);
            Date endTimeDate = DateFormatUtil.getDateByStringDate(endTime);
            if (endTimeDate.before(startTimeDate)) {
                log.info("endTime is befor startTime.");

                return false;
            }
        }
        return true;
    }

    /**
     * 转换TpTaskChild对象中相关字段信息
     *
     * @param tpTaskChild
     * @return
     */
    public TpTaskChild convertTpTaskChildField(TpTaskChild tpTaskChild) {

        //转换发起人的真实姓名
        String initiatorRealname = userOperator.getRealnameByUsername(tpTaskChild.getInitiator());
        tpTaskChild.setInitiatorRealname(initiatorRealname);
        log.debug("convert initiator's realname:" + tpTaskChild.getInitiator() + "-->" + initiatorRealname);

        //转换责任人真实姓名
        String responsiblemanRealname = userOperator.getRealNameSeqByUsernameSeq(tpTaskChild.getResponsibleman());
        tpTaskChild.setResponsiblemanRealname(responsiblemanRealname);
        log.debug("convert responsibleman's realname:" + tpTaskChild.getResponsibleman() + "-->" + responsiblemanRealname);

        //转换执行人真实姓名
        String executorRealname = userOperator.getRealNameSeqByUsernameSeq(tpTaskChild.getExecutor());
        tpTaskChild.setExecutorRealname(executorRealname);
        log.debug("convert executor's realname:" + tpTaskChild.getExecutor() + "-->" + executorRealname);

        //转换任务来源名称
        String taskSourceName = TaskConstant.getTaskSourceName(tpTaskChild.getTaskSource());
        tpTaskChild.setTaskSourceName(taskSourceName);
        log.debug("convert taskSource's name:" + tpTaskChild.getTaskSource() + "-->" + taskSourceName);

        //转换任务类型名称
        String taskTypeName = TaskConstant.getTaskTypeName(tpTaskChild.getTaskType());
        tpTaskChild.setTaskTypeName(taskTypeName);
        log.debug("convert taskType's name:" + tpTaskChild.getTaskType() + "-->" + taskTypeName);

        //转换任务状态名称
        String taskStatusName = TaskConstant.getTaskStatusName(tpTaskChild.getTaskStatus());
        tpTaskChild.setTaskStatusName(taskStatusName);
        log.debug("convert taskStatus's name:" + tpTaskChild.getTaskStatus() + "-->" + taskStatusName);

        //转换优先级名称
        String priorityName = TaskConstant.getPriorityName(tpTaskChild.getPriority());
        tpTaskChild.setPriorityName(priorityName);
        log.debug("convert priority's name:" + tpTaskChild.getPriority() + "-->" + priorityName);

        return tpTaskChild;

    }

}
