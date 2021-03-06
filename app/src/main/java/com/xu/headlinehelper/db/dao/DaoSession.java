package com.xu.headlinehelper.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.xu.headlinehelper.db.dbbean.DownLoadSettingDbBean;

import com.xu.headlinehelper.db.dao.DownLoadSettingDbBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig downLoadSettingDbBeanDaoConfig;

    private final DownLoadSettingDbBeanDao downLoadSettingDbBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        downLoadSettingDbBeanDaoConfig = daoConfigMap.get(DownLoadSettingDbBeanDao.class).clone();
        downLoadSettingDbBeanDaoConfig.initIdentityScope(type);

        downLoadSettingDbBeanDao = new DownLoadSettingDbBeanDao(downLoadSettingDbBeanDaoConfig, this);

        registerDao(DownLoadSettingDbBean.class, downLoadSettingDbBeanDao);
    }
    
    public void clear() {
        downLoadSettingDbBeanDaoConfig.clearIdentityScope();
    }

    public DownLoadSettingDbBeanDao getDownLoadSettingDbBeanDao() {
        return downLoadSettingDbBeanDao;
    }

}
