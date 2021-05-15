package org.tty.gsemulator.gs.role

import org.tty.gsemulator.gs.state.GsElement

/**
 * GsInfo人物的基础属性
 */
class GsInfo {
    /**
     * 角色姓名
     */
    lateinit var name: String
    lateinit var sex: GsSex
    /**
     * 人物使用的元素
     */
    lateinit var element: GsElement
    /**
     * 人物使用的武器
     */
    lateinit var weapon: GsWeapon
    /**
     * 命之座
     */
    lateinit var star: String
    /**
     * 所属组织
     */
    lateinit var org: String
}