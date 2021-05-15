package org.tty.gsemulator.gs.role

enum class GsWeapon(
    val id: String
) {
    /**
     * 单手剑
     */
    Sword("sword"),
    /**
     * 双手剑
     */
    TSword("tSword"),
    /**
     * 弓箭
     */
    Bow("bow"),
    /**
     * 长柄武器
     */
    Spear("spear"),
    /**
     * 法器
     */
    Magic("magic")
}