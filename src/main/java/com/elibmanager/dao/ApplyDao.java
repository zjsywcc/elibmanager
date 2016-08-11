package com.elibmanager.dao;

import com.elibmanager.model.Apply;

/**
 * Created by mengchenyun on 2016/8/8.
 */
public interface ApplyDao {

    Apply getApplyById(int applyId);

    void deleteApply(Apply apply);

    void editApply(Apply apply);

}
