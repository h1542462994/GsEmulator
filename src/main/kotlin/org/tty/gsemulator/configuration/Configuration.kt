package org.tty.gsemulator.configuration


/**
 * 基础配置类，可以按照名称找到需要的配置
 */
interface Configuration {
    /**
     * 按照名称查找配置
     */
    fun getConfig(name: String): Any
}