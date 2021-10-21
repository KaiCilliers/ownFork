package com.example.scriptsample

import timber.log.Timber
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class Logging {

}
//asdljasldjasldasdada

// todo man
// todo ok
class TimberLoggerProperty<T : Any>(private val tag: String? = null) :
    ReadOnlyProperty<T, TimberLogger> {

    @Volatile var logger: TimberLogger? = null

    override fun getValue(thisRef: T, property: KProperty<*>): TimberLogger {
        logger?.let { return it }
        logger = TimberLogger(thisRef, tag)
        return logger!!
    }
}

class TimberLogger(thisRef: Any, tag: String? = null) : Timber.Tree() {

    private val tag = tag ?: thisRef.toTag()

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        Timber.tag(tag ?: this.tag).log(priority, t, message)
    }

    private fun Any.toTag(): String {
        val str = this::class.java.simpleName
            .run { if (endsWith("Impl")) substring(0, length - 4) else this }
        if (str.length <= 23) {
            return str
        }
        return str
            .replace("Fragment", "Frag")
            .replace("ViewModel", "VM")
            .replace("Controller", "Ctrl")
            .replace("Manager", "Mgr")
            .take(23)
    }
}