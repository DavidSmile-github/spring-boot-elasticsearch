package com.nox.player.appcenter.en.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户基础信息表

 * </p>
 *
 * @author David
 * @since 2020-04-09
 */
@TableName("account")
@Data
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 签名
     */
    private String sign;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态（0：不可用，1：可用）
     */
    private Integer status;

    /**
     * 是否逻辑删除（0：否，1：是）
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;

    @Override
    protected Serializable pkVal() {
       return this.id;
    }
}
