package com.ssk.retailshop.notification;

public interface CallbackSSk<T> {
    void Success(T response, String message);
    void Fail(Throwable throwable);
}
