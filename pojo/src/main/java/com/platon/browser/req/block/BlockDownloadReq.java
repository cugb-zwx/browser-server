package com.platon.browser.req.block;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 节点区块详情下载请求对象
 */
@Data
public class BlockDownloadReq {
    @NotBlank(message = "{chain.id.notnull}")
    private String cid;
    @NotBlank(message = "{node.address.notnull}")
    private String address;
    private Date startDate;
    @NotNull(message = "{download.date.start.notnull}")
    @Past(message = "{download.date.start.must.less.than.now}")
    private Date endDate;
}