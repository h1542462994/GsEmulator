package org.tty.gsemulator.util

/**
 * 计算线性插值
 */
fun lerp(min: Double, max: Double, percent: Double): Double {
    return min + (max - min) * percent
}

/**
 * 计算比例
 */
fun percent(min: Double, max: Double, current: Double): Double {
    return (current - min) / (max - min)
}

/**
 * 计算线性插值
 */
fun lerp(min: Int, max: Int, percent: Double): Double {
    return lerp(min.toDouble(), max.toDouble(), percent)
}

/**
 * 计算比例
 */
fun percent(min: Int, max: Int, current: Int): Double {
    return percent(min.toDouble(), max.toDouble(), current.toDouble())
}