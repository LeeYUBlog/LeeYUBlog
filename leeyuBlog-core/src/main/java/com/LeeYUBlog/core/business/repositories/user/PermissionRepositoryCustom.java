package com.LeeYUBlog.core.business.repositories.user;

import com.LeeYUBlog.core.model.user.PermissionCriteria;
import com.LeeYUBlog.core.model.user.PermissionList;

public interface PermissionRepositoryCustom {

	PermissionList listByCriteria(PermissionCriteria criteria);
}
