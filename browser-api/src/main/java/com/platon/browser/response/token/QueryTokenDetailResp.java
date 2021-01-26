package com.platon.browser.response.token;

import com.platon.browser.bean.CustomTokenDetail;
import com.platon.browser.utils.ConvertUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 合约信息详情返回
 *
 * @author AgentRJ
 * @create 2020-09-23 14:35
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class QueryTokenDetailResp {

    @ApiModelProperty(value = "合约地址")
    private String address;
    @ApiModelProperty(value = "合约名称")
    private String name;
    @ApiModelProperty(value = "合约类型")
    private String type;
    @ApiModelProperty(value = "合约符号")
    private String symbol;
    @ApiModelProperty(value = "合约精度")
    private Integer decimal;
    @ApiModelProperty(value = "合约发行总量")
    private String totalSupply;
    @ApiModelProperty(value = "合约图标（base64编码）")
    private String icon;
    @ApiModelProperty(value = "合约创建者")
    private String creator;
    @ApiModelProperty(value = "合约部署所在哈希")
    private String txHash;
    @ApiModelProperty(value = "合约对应官方网站")
    private String webSite;
    @ApiModelProperty(value = "合约创建时间")
    private Date blockTimestamp;
    @ApiModelProperty(value = "持有人数")
    private Integer holder;
    @ApiModelProperty(value = "交易记录时间")
    private Date createTime;

    // attach info, maybe is empty.
    @ApiModelProperty(value = "合约内部交易数")
    private Integer txCount;
    @ApiModelProperty(value = "合约ABI接口描述")
    private String abi;
    @ApiModelProperty(value = "合约二进制码")
    private String binCode;
    @ApiModelProperty(value = "合约源码")
    private String sourceCode;

    public static QueryTokenDetailResp fromTokenDetail(CustomTokenDetail token) {
        if (null == token) {
            return null;
        }
        BigDecimal totalSupply = BigDecimal.ZERO;
        if(token.getTotalSupply() != null && token.getDecimal()!=null){
            totalSupply = ConvertUtil.convertByFactor(token.getTotalSupply(), token.getDecimal());
        }
        return QueryTokenDetailResp.builder()
                .address(token.getAddress()).name(token.getName())
                .symbol(token.getSymbol()).decimal(token.getDecimal())
                .totalSupply(totalSupply.toString())
                .creator(token.getCreator()).txHash(token.getTxHash())
                .txCount(token.getTxCount())
                .createTime(token.getCreateTime())
                .holder(token.getHolder())
                .binCode(token.getBinCode())
                .webSite(token.getWebSite())
                .build();
    }
}
