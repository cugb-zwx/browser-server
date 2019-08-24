package com.platon.browser.dto;

import com.platon.browser.dao.entity.Vote;
import com.platon.browser.param.VotingProposalParam;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Chendongming
 * @Date: 2019/8/16 15:36
 * @Description:
 */
@Data
public class CustomVote extends Vote {

    public void updateWithVote( CustomTransaction tx, VotingProposalParam param ){
        this.setCreateTime(new Date());
        this.setUpdateTime(new Date());
        this.setHash(tx.getHash());
        this.setProposalHash(param.getProposalId());
        this.setOption(param.getOption());
        this.setTimestamp(tx.getTimestamp());
        this.setVerifier(param.getVerifier());
    }

    public OptionEnum getOptionEnum(){
        return OptionEnum.getEnum(this.getOption());
    }

    public enum OptionEnum {
        SUPPORT("1", "支持"),
        OPPOSITION("2", "反对"),
        ABSTENTION("3", "弃权");
        public String code;
        public String desc;
        OptionEnum ( String code, String desc ) {
            this.code = code;
            this.desc = desc;
        }
        public String getCode () {
            return code;
        }
        public String getDesc () {
            return desc;
        }
        private static Map<String, OptionEnum> ENUMS = new HashMap<>();
        static {
            Arrays.asList(OptionEnum.values()).forEach(en -> ENUMS.put(en.code, en));
        }
        public static OptionEnum getEnum ( String code ) {
            return ENUMS.get(code);
        }
        public static boolean contains ( String code ) {
            return ENUMS.containsKey(code);
        }
        public static boolean contains ( OptionEnum en ) {
            return ENUMS.containsValue(en);
        }
    }
}
