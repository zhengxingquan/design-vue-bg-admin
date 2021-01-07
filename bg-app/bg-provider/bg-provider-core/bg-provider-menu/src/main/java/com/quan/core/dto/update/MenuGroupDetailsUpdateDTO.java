package com.quan.core.dto.update;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 系统菜单分组与菜单对应表 编辑请求类
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-07 18:49:57
 */

@Getter
@Setter
@Data
public class MenuGroupDetailsUpdateDTO {

    /**
     * 菜单分组ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuGroupId;
    /**
     * 菜单ID
     */
        @JsonSerialize(using = ToStringSerializer.class)
        private Long menuId;

}
