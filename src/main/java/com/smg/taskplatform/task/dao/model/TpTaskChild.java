package com.smg.taskplatform.task.dao.model;

import com.magicube.framework.common.utils.DateFormatUtil;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author justincai
 */
public class TpTaskChild extends TpTask {

    private static final Log log = LogFactory.getLog(TpTaskChild.class);

    /**
     * 开始时间
     */
    private String showStarttime;

    /**
     * 截止时间
     */
    private String showEndtime;

    public String getShowStarttime() {
        return showStarttime;
    }

    public void setShowStarttime(String showStarttime) {
        this.showStarttime = showStarttime;
        if (!StringUtils.isEmpty(showStarttime)) {
            Date date = DateFormatUtil.getDateByStringDate(showStarttime);
            setStarttime(date.getTime());
        }
    }

    public String getShowEndtime() {
        return showEndtime;
    }

    public void setShowEndtime(String showEndtime) {
        this.showEndtime = showEndtime;
        if (!StringUtils.isEmpty(showEndtime)) {
            Date date = DateFormatUtil.getDateByStringDate(showEndtime);
            setStarttime(date.getTime());
        }
    }

    @Override
    public void setSummary(String summary) {
        super.setSummary(summary); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSummary() {
        return super.getSummary(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setReportingCycle(Byte reportingCycle) {
        super.setReportingCycle(reportingCycle); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Byte getReportingCycle() {
        return super.getReportingCycle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setServerAssociation(String serverAssociation) {
        super.setServerAssociation(serverAssociation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getServerAssociation() {
        return super.getServerAssociation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSystemAssociation(String systemAssociation) {
        super.setSystemAssociation(systemAssociation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSystemAssociation() {
        return super.getSystemAssociation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTaskAssociation(String taskAssociation) {
        super.setTaskAssociation(taskAssociation); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTaskAssociation() {
        return super.getTaskAssociation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEndtime(Long endtime) {
        super.setEndtime(endtime); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getEndtime() {
        return super.getEndtime(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTaskStatus(Byte taskStatus) {
        super.setTaskStatus(taskStatus); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Byte getTaskStatus() {
        return super.getTaskStatus(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStarttime(Long starttime) {
        super.setStarttime(starttime); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getStarttime() {
        return super.getStarttime(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPriority(Byte priority) {
        super.setPriority(priority); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Byte getPriority() {
        return super.getPriority(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTaskSource(Byte taskSource) {
        super.setTaskSource(taskSource); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Byte getTaskSource() {
        return super.getTaskSource(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTaskType(Byte taskType) {
        super.setTaskType(taskType); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Byte getTaskType() {
        return super.getTaskType(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOperatorlist(String operatorlist) {
        super.setOperatorlist(operatorlist); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOperatorlist() {
        return super.getOperatorlist(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCc(String cc) {
        super.setCc(cc); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCc() {
        return super.getCc(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setExecutor(String executor) {
        super.setExecutor(executor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getExecutor() {
        return super.getExecutor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResponsibleman(String responsibleman) {
        super.setResponsibleman(responsibleman); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getResponsibleman() {
        return super.getResponsibleman(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setInitiator(String initiator) {
        super.setInitiator(initiator); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInitiator() {
        return super.getInitiator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription() {
        return super.getDescription(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitle() {
        return super.getTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTaskId(Integer taskId) {
        super.setTaskId(taskId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getTaskId() {
        return super.getTaskId(); //To change body of generated methods, choose Tools | Templates.
    }

}