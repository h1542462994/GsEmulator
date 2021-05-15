package org.tty.gsemulator.configuration

import java.beans.IntrospectionException
import java.beans.PropertyDescriptor

/**
 * 运行参数类，支持设置参数和读取参数
 */
interface Arg {
    fun getArg(name: String): Any {
        try {
            val propertyDescriptor = PropertyDescriptor(name, this.javaClass)
            return propertyDescriptor.readMethod.invoke(this)
        } catch (e: IntrospectionException) {
            throw IllegalArgumentException("key not exists", e)
        }
    }
    fun setArg(name: String, value: Any) {
        try {
            val propertyDescriptor = PropertyDescriptor(name, this.javaClass)
            propertyDescriptor.writeMethod.invoke(this, value)
        } catch (e: IntrospectionException) {
            throw IllegalArgumentException("key not exists", e)
        }
    }
}