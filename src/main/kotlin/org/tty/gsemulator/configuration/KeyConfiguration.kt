package org.tty.gsemulator.configuration

/**
 * 按照键查找的配置类
 */
interface KeyConfiguration<K>: Configuration {
    fun getConfig(key: K): Any
}