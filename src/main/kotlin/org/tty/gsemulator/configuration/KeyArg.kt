package org.tty.gsemulator.configuration

import org.tty.gsemulator.gs.state.GsElement
import org.tty.gsemulator.gs.state.GsElementProperty
import java.beans.IntrospectionException
import java.beans.PropertyDescriptor

interface KeyArg<K>: Arg{
    fun getArg(key: K): Any
    fun setArg(key: K, value: Any)
}