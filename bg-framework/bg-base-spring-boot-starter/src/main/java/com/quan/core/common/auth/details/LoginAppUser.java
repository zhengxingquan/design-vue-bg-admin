package com.quan.core.common.auth.details;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quan.core.common.model.SysRole;
import com.quan.core.common.model.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/***
 * 用户实体绑定spring security
 *
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/6 15:55
 */
@Data
public class LoginAppUser extends SysUser implements UserDetails {

    private static final long serialVersionUID = -3685249101751401211L;

    /***
     *   
     * 角色
     */  
    private Set<SysRole> sysRoles;

    /***
     * 权限
     */
    private Set<String> permissions;

    /***
     * 权限重写
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        Collection<GrantedAuthority> synchronizedCollection = Collections.synchronizedCollection(collection);
        if (!CollectionUtils.isEmpty(sysRoles)) {
            sysRoles.parallelStream().forEach(role -> {
                if (role.getCode().startsWith("ROLE_")) {
                    synchronizedCollection.add(new SimpleGrantedAuthority(role.getCode()));
                } else {
                    synchronizedCollection.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
                }
            });
        }

        if (!CollectionUtils.isEmpty(permissions)) {
            permissions.parallelStream().forEach(per -> {
                synchronizedCollection.add(new SimpleGrantedAuthority(per));
            });
        }
        return collection;
    }


    @JsonIgnore
    public Collection<? extends GrantedAuthority> putAll(Collection<GrantedAuthority> collections) {
        Collection<GrantedAuthority> collection = new HashSet<>();
        collection.addAll(collections);
        return collection;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }

}
