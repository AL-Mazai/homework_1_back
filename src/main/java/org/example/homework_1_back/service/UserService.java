package org.example.homework_1_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.homework_1_back.domain.entity.User;
import org.example.homework_1_back.domain.vo.UserVo;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-04-08 19:53:54
 */
public interface UserService extends IService<User>{

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * 登录校验
     * @param userName
     * @param password
     * @return
     */
    UserVo validateUser(String userName, String password);

    void updateUserInfo(User user);
}
