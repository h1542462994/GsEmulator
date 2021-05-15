package org.tty.gsemulator.gs.state

import org.tty.gsemulator.configuration.KeyArg
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor
import kotlin.math.roundToInt
import kotlin.reflect.KClass

/**
 * 与元素相关的属性
 */
class GsElementProperty: KeyArg<GsElement> {
    var fire: Double = 0.0
    var water: Double = 0.0
    var wind: Double = 0.0
    var thunder: Double = 0.0
    var grass: Double = 0.0
    var ice: Double = 0.0
    var rock: Double = 0.0

    override fun getArg(key: GsElement): Any {
        return getArg(key.id)
    }

    override fun setArg(key: GsElement, value: Any) {
        setArg(key.id, value)
    }

    override fun toString(): String {
        return "[火:${fire.roundToInt()}%,水:${water.roundToInt()}%,风:${wind.roundToInt()}%,雷:${thunder.roundToInt()}%,草${grass.roundToInt()}%,冰:${ice.roundToInt()}%,岩:${rock.roundToInt()}%]"
    }
}