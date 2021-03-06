package com.quan.core.constant.meta;

import com.quan.core.constant.exception.BaseException;
import com.quan.core.constant.util.Strings;

import java.io.Serializable;

/**
 * @author 郑兴泉 956607644@qq.com
 * @data 2020/12/17
 * 描述：
 */
public class Email implements Cloneable, Serializable {

    private String account;
    private String host;

    public Email() {
    }

    public Email(String str) {
        try {
            int pos = str.indexOf('@');
            this.account = str.substring(0, pos);
            this.host = str.substring(pos + 1, str.length());
        } catch (Exception e) {
            throw new BaseException("Error email format [%s]", str);
        }
        if (Strings.isBlank(account) || Strings.isBlank(host) || host.indexOf('.') < 0) {
            throw new BaseException("Error email format [%s]", str);
        }
    }

    public Email(String account, String host) {
        this.account = account;
        this.host = host;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public int hashCode() {
        if (null == account)
            return 0;
        return account.hashCode();
    }

    @Override
    public Email clone() throws CloneNotSupportedException {
        return new Email(account, host);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!Email.class.isAssignableFrom(obj.getClass()))
            return false;
        if (!account.equals(((Email) obj).account))
            return false;
        if (!host.equals(((Email) obj).host))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s@%s", account, host);
    }
}
