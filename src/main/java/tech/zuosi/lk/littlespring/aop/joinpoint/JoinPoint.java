package tech.zuosi.lk.littlespring.aop.joinpoint;

/**
 * Interface:
 *
 * getArgs(): Returns the method arguments.
 *
 * getThis(): Returns the proxy object.
 *
 * getTarget(): Returns the target object.
 *
 * getSignature(): Returns a description of the method that is being advised.
 *
 * toString(): Prints a useful description of the method being advised.
 */
public class JoinPoint {
    protected Object[] args;
    protected Object proxy;
    protected Object target;

    public JoinPoint(Object[] args, Object proxy, Object target) {
        this.args = args;
        this.proxy = proxy;
        this.target = target;
    }

    /**
     * @return 方法参数
     */
    Object[] getArgs() {
        return this.args;
    }

    /**
     * @return 代理对象
     */
    Object getThis() {
        return this.proxy;
    }

    /**
     * @return 目标对象
     */
    Object getTarget() {
        return this.target;
    }

    /**
     * 被通知方法的签名
     */
    //Signature getSignature();

    /**
     * @return 被通知方法的描述
     */
    //String toString();
}
