package org.example.homework_1_back.controller;

import jakarta.annotation.Resource;
import org.example.homework_1_back.domain.ResponseResult;
import org.example.homework_1_back.domain.entity.User;
import org.example.homework_1_back.domain.vo.UserVo;
import org.example.homework_1_back.enums.AppHttpCodeEnum;
import org.example.homework_1_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.homework_1_back.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;



/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-04-08 19:53:52
 */
@RestController
@RequestMapping("user")
public class UserController {
    final
    UserDao userDao;

    public UserController(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/recharge")
    public ResponseResult recharge(@RequestParam Integer userId, @RequestParam Integer amount) {
        User user = userDao.getUserById(userId);
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.USERNAME_NOT_NULL, "用户不存在");
        }
        // 更新用户的余额
        user.setMoney(user.getMoney() + amount);
        int updateResult = userDao.updateById(user);
        if (updateResult > 0) {
            return ResponseResult.okResult("充值成功");
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR, "充值失败");
        }
    }
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

    /**
     * 注册新用户
     *
     * @param user 要注册的用户信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        System.out.println(user);
        // 保存用户信息
        userService.save(user);
        return ResponseResult.okResult();
    }

    /**
     * 用户登录
     * @return 登录结果
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        // 校验用户名和密码
        UserVo userVo = userService.validateUser(user.getUserName(), user.getPassword());
        if (userVo != null) {
            // 如果校验成功，查询用户信息并返回
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS, userVo);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR);
        }
    }

    @PostMapping("/updateUserInfo")
    public ResponseResult updateUserInfo(@RequestBody User user){
        userService.updateUserInfo(user);
        return ResponseResult.okResult();
    }

}

