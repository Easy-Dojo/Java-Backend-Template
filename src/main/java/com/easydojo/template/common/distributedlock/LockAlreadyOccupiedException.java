package com.easydojo.template.common.distributedlock;


import com.easydojo.template.common.exception.AppException;
import com.easydojo.template.common.exception.ErrorCode;
import com.google.common.collect.ImmutableMap;

public class LockAlreadyOccupiedException extends AppException {
    public LockAlreadyOccupiedException(String lockKey) {
        super(ErrorCode.LOCK_OCCUPIED, ImmutableMap.of("lockKey", lockKey));
    }
}
