package com.wongdee.lock.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Lock {

	//锁名称
	public String LockName() default "";
	
	//锁的等待时间 -- 请求等待时间，超过这个时间结束此次请求。在这个时间之内锁被释放了就执行请求。
	public long AcquireTime() default 0L;
	
	//锁的生命期时间 -- redis中的过期时间
	public long lockTime() default 0L;
	
}
