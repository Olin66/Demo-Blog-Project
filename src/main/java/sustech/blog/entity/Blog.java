package sustech.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_blog")
public class Blog implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("title")
    @NotBlank(message = "The title can not be left empty!")
    private String title;

    @TableField("description")
    private String description;

    @TableField("content")
    @NotBlank(message = "The content can not be left empty!")
    private String content;

    @TableField("created_time")
    private LocalDate createdTime;

    @TableField("status")
    private Integer status;

    @TableField("visited_num")
    private Integer visitedNum;


}
