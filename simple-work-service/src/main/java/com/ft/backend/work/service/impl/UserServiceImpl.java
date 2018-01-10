package com.ft.backend.work.service.impl;

import com.ft.backend.work.client.common.ResultCode;
import com.ft.backend.work.client.common.ReturnResult;
import com.ft.backend.work.client.service.UserService;
import com.ft.backend.work.client.vo.UserVo;
import com.ft.backend.work.dao.UserMapper;
import com.ft.backend.work.model.User;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


/**
 * Created by huanghongyi on 2016/12/3.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger= LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public ReturnResult<UserVo> add(UserVo userVo) {

        logger.info("UserService - add begin, userVo={}",userVo);

        ReturnResult<UserVo> result =null;

        if(StringUtils.isBlank(userVo.getUserName().trim()) ){
             return  new ReturnResult<>(ResultCode.USER_USERNAME_NULL);
        }

        if(StringUtils.isBlank(userVo.getUserName().trim())){
            return  new ReturnResult<>(ResultCode.USER_PASSWORD_NULL);
        }

        try {

            User user=new User();
            BeanUtils.copyProperties(userVo,user);
            user.setStatus(UserVo.STATUS_NORMAL);
            user.setCreateTime(new Date());

            int id=userMapper.insert(user);

            BeanUtils.copyProperties(user,userVo);

            result= ReturnResult.getNewSuccessedInstance(userVo);
        }
        catch (Exception e)
        {
           result = ReturnResult.getNewFailedInstance();
            logger.error("UserService - add error,error={}",e);
        }

        logger.info("UserService - add end, result={}",result);
        return result;
    }

    @Override
    public ReturnResult<UserVo> getById(Long id) {

        logger.info("UserService - getById begin, id={}",id);

        ReturnResult<UserVo> result=null;
        try{
            User user=userMapper.selectByPrimaryKey(id);

            UserVo userVo= new UserVo();
            BeanUtils.copyProperties(user,userVo);

            result = ReturnResult.getNewSuccessedInstance(userVo);

        }catch (Exception e){
            result=ReturnResult.getNewFailedInstance();
            logger.error("UserService - getById error,error={}",e);
        }
        logger.info("UserService - getById end, result={}",result);
        return null;
    }

    @Override
    public ReturnResult<UserVo> getByUsernameAndPassword(String username, String password) {
        logger.info("UserService - getByUsernameAndPassword begin, username={},password={}",username,password);

        ReturnResult<UserVo> result =null;

        if(StringUtils.isBlank(username) ){
            return  new ReturnResult<>(ResultCode.USER_USERNAME_NULL);
        }

        if(StringUtils.isBlank(password)){
            return  new ReturnResult<>(ResultCode.USER_PASSWORD_NULL);
        }

        try {

            Map<String,Object> params=new HashedMap();
            params.put("userName",username);
            params.put("password",password);

            User user=userMapper.selectByUsernameAndPassword(params);
            UserVo userVo=new UserVo();
            BeanUtils.copyProperties(user,userVo);

            result= ReturnResult.getNewSuccessedInstance(userVo);
        }
        catch (Exception e)
        {
            result = ReturnResult.getNewFailedInstance();
            logger.error("UserService - getByUsernameAndPassword error,error={}",e);
        }

        logger.info("UserService - getByUsernameAndPassword end, result={}",result);
        return result;
    }
}
