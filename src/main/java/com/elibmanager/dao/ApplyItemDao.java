package com.elibmanager.dao;

import com.elibmanager.model.Apply;
import com.elibmanager.model.ApplyItem;

/**
 * Created by wcc on 2016/8/8.
 */
public interface ApplyItemDao {

    void addApplyItem(ApplyItem applyItem);

    void removeApplyItem(ApplyItem applyItem);

    void removeAllApplyItems(Apply apply);

    ApplyItem getApplyItemByBookId(int bookId);

}
