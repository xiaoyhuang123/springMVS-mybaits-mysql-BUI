package com.ft.backend.work.client.service;

import com.ft.backend.work.client.common.ReturnResult;
import com.ft.backend.work.client.vo.UserVo;

/**
 * Created by huanghongyi on 2016/12/3.
 */
public interface UserService {
    ReturnResult<UserVo> add(UserVo userVo);

    ReturnResult<UserVo> getById(Long id);

    ReturnResult<UserVo> getByUsernameAndPassword(String username,String password);
}
