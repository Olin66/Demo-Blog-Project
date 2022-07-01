package sustech.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("pwd")
    private String pwd;

    @TableField("avatar")
    private String avatar;

    @TableField("email")
    private String email;

    @TableField("status")
    private Integer status;

    @TableField("created_time")
    private LocalDate createdTime;

    @TableField("last_login_time")
    private LocalDate lastLoginTime;


}
