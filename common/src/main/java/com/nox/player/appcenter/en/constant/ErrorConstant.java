package com.nox.player.appcenter.en.constant;

/**
 * @author 多点哈哥
 */

public enum ErrorConstant {
    DEPRECATED_SERVICE(-2, "版本已过期，请更新到最新版本！"),
    SERVER_ERROR(-1, "Server Error"),
    SUCCESS(0, "SUCCESS"),


    //文件删除异常
    UNRECOGNIZABLE_FILE_TYPE(1001001, "不能识别的文件类型"),
    //实体已存在，不可重复插入
    REPEAT_INSERT(1001002, "实体已存在，不可重复插入"),
    //实体已存在，不可重复插入
    ENTITY_NOT_EXIST(1001003, "要操作的实体不存在"),
    //必填数据不可为空
    REQUIRED_IS_BLANK(1001004, "必填数据不可为空"),
    //发现相关的异常信息
    PUBLISHED_DISCOVER_LESS_4(1001005, "上架发现不能小于4个"),

    GAME_ID_EMPTY(1001006, "gameId 不能为空"),
    UID_EMPTY(1001007, "uid 不能为空"),
    STATUS_EMPTY(1001008, "status 不能为空"),
    GAME_MUST_BE_REVERSE(1001009, "预约的游戏必须为预约游戏"),
    GAME_MUST_BE_REVERSE_ONLINE(1001010, "预约的游戏必须为预约上线状态"),
    GIFT_ID_EMPTY(1001011, "礼包ID 不能为空"),
    GIFT_HAS_BEEN_BIND(1001012, "您已领取过本礼包，请勿重复领取"),
    GIFT_INVALID(1001013, "礼包已过期"),
    GIFT_SURPLUS_TIMES_EXHAUSTED(1001014, "礼包被领光"),
    GIFT_RECEIVE_FAILED(1001015, "礼包领取失败"),
    GAME_MUST_BE_PRODUCT_REVERSE_AUTO(1001016, "游戏必须为预约、已上线状态"),
    GAME_NOT_EXISTS(1001017, "游戏不存在"),


    ACCESS_TOKEN_INVALID(10000, "accessToken已失效");
    private int code;
    private String message;

    ErrorConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
