package com.platon.browser.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Token {
    private String address;

    private String type;

    private String name;

    private String symbol;

    private String totalSupply;

    private Integer decimal;

    private Boolean isSupportErc165;

    private Boolean isSupportErc20;

    private Boolean isSupportErc721;

    private Boolean isSupportErc721Enumeration;

    private Boolean isSupportErc721Metadata;

    private Date createTime;

    private Date updateTime;

    private Integer tokenTxQty;

    private Integer holder;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public String getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(String totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    public Boolean getIsSupportErc165() {
        return isSupportErc165;
    }

    public void setIsSupportErc165(Boolean isSupportErc165) {
        this.isSupportErc165 = isSupportErc165;
    }

    public Boolean getIsSupportErc20() {
        return isSupportErc20;
    }

    public void setIsSupportErc20(Boolean isSupportErc20) {
        this.isSupportErc20 = isSupportErc20;
    }

    public Boolean getIsSupportErc721() {
        return isSupportErc721;
    }

    public void setIsSupportErc721(Boolean isSupportErc721) {
        this.isSupportErc721 = isSupportErc721;
    }

    public Boolean getIsSupportErc721Enumeration() {
        return isSupportErc721Enumeration;
    }

    public void setIsSupportErc721Enumeration(Boolean isSupportErc721Enumeration) {
        this.isSupportErc721Enumeration = isSupportErc721Enumeration;
    }

    public Boolean getIsSupportErc721Metadata() {
        return isSupportErc721Metadata;
    }

    public void setIsSupportErc721Metadata(Boolean isSupportErc721Metadata) {
        this.isSupportErc721Metadata = isSupportErc721Metadata;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTokenTxQty() {
        return tokenTxQty;
    }

    public void setTokenTxQty(Integer tokenTxQty) {
        this.tokenTxQty = tokenTxQty;
    }

    public Integer getHolder() {
        return holder;
    }

    public void setHolder(Integer holder) {
        this.holder = holder;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table token
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        address("address", "address", "VARCHAR", false),
        type("type", "type", "VARCHAR", true),
        name("name", "name", "VARCHAR", true),
        symbol("symbol", "symbol", "VARCHAR", false),
        totalSupply("total_supply", "totalSupply", "VARCHAR", false),
        decimal("decimal", "decimal", "INTEGER", true),
        isSupportErc165("is_support_erc165", "isSupportErc165", "BIT", false),
        isSupportErc20("is_support_erc20", "isSupportErc20", "BIT", false),
        isSupportErc721("is_support_erc721", "isSupportErc721", "BIT", false),
        isSupportErc721Enumeration("is_support_erc721_enumeration", "isSupportErc721Enumeration", "BIT", false),
        isSupportErc721Metadata("is_support_erc721_metadata", "isSupportErc721Metadata", "BIT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        tokenTxQty("token_tx_qty", "tokenTxQty", "INTEGER", false),
        holder("holder", "holder", "INTEGER", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table token
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}