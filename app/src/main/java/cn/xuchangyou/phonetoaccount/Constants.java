package cn.xuchangyou.phonetoaccount;

/**
 * Created by Administrator on 2017/12/15.
 */

public interface Constants {
    /**
     * 账号类型key
     */
    String ACCOUNT_DB_NAME = "account";
    /**
     * 账号类型key
     */
    String ACCOUNT_TYPE = "ACCOUNT_TYPE";
    /**
     * 初始化完成后保存的标记
     */
    String IS_INITED = "IS_INITED";
    /**
     * 账号保存到db的前缀 类似account:1
     */
    String ACCOUNT_PREFIX = "account";
    /**
     * 加密盐
     */
    String PWD_MESSAGE= "asdhfkjs29348skdjflj";
    /**
     * 添加账号成功后的resultCode
     */
    int ADD_ACCOUNT_CODE = 101;
    /**
     * 添加账号成功后的操作
     */
    String ADD_ACCOUNT_ACTION = "ADD_ACCOUNT_ACTION";
    /**
     * 添加的账号信息
     */
    String NEW_ACCOUNT_INFO = "NEW_ACCOUNT_INFO";
}
