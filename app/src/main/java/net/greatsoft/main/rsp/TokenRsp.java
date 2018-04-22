package net.greatsoft.main.rsp;

import net.greatsoft.main.control.FuResponse;

/**
 * Created by zhanglin on 2016/12/5.
 */

public class TokenRsp extends FuResponse{
    /**
     * 应用要获取的Access Token
     */
    private String access_token;
    /**
     * Access Token的有效期，以秒为单位
     */
    private String expires_in;
    /**
     * 用于刷新Access Token 的 Refresh Token
     */
    private String refresh_token;
    /**
     * Access Token最终的访问范围。
     */
    private String scope;


    private String error_description;

    private String error;

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
