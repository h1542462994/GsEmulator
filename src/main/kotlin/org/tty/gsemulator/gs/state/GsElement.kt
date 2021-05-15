package org.tty.gsemulator.gs.state

/**
 * Genshin中的元素种类
 */
enum class GsElement(
    val id: String
) {
    /**
     * 火属性 fire
     */
    Fire("fire"),
    /**
     * 水属性 water
     */
    Water("water"),
    /**
     * 风属性 wind
     */
    Wind("wind"),
    /**
     * 雷属性
     */
    Thunder("thunder"),
    /**
     * 草属性
     */
    Grass("grass"),
    /**
     * 冰属性
     */
    Ice("ice"),
    /**
     * 岩属性
     */
    Rock("rock")
}