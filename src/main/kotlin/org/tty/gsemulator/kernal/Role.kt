package org.tty.gsemulator.kernal

import org.tty.gsemulator.configuration.Configuration

/**
 * 表示一个角色或者单位，也是Emulator的核心
 * 这里所有的接口都是空接口，主要是为了提供编程的范式。
 */
interface Role {
    fun state(): State
    /**
     * 不再运动时变化的参数
     */
    fun configuration(): Configuration
    /**
     * 可以在运行时变动的参数
     */
    fun args(): Configuration
    /**
     * 影响的集合
     */
    fun effects(): List<Effect>
    /**
     * 动作的集合
     */
    fun actions(): List<Action>
}