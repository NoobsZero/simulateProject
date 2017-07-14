package com.smg.framework.examples.pagination;

import com.smg.framework.common.SpringUtil;
import com.smg.framework.pagination.Page;
import com.smg.framework.pagination.PageDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 分页功能-样例:Service类，提供该业务分页操作功能
 *
 * @author justincai
 */
public class PageService {

    private static final Log log = LogFactory.getLog(PageService.class);

    private JdbcTemplate jdbcTemplate;

    private PageDao pd = null;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page getActionSettingPage(int pageNum) {

        String sql = "select count(*) from actionsetting";
        int totalRecord = pd.getTotalRecord(sql);

        sql = "select * from actionsetting";
        Page page = pd.getPage(pageNum, ActionSetting.class, sql, totalRecord);
        return page;

    }

    public PageDao getPd() {
        return pd;
    }

    public void setPd(PageDao pd) {
        this.pd = pd;
    }

    public static void main(String[] args) {
        PageService ps = (PageService)SpringUtil.getBean("pageService");

        Page page = ps.getActionSettingPage(4);
    }

}
