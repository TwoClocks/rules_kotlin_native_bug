package app

import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.Linker
import java.lang.foreign.MemorySegment
import java.lang.foreign.SymbolLookup
import java.lang.foreign.ValueLayout

fun main(args: Array<String>) {
    System.loadLibrary("native-lib")

    val lookup = SymbolLookup.loaderLookup()
    val linker = Linker.nativeLinker()
    val fnAddr = lookup.find("getNativeString").orElseThrow()
    val fnDesc = FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT)
    val getString = linker.downcallHandle(fnAddr, fnDesc)

    val ptr = getString.invoke(99) as MemorySegment
    val range = ptr.reinterpret(265)
    val nativeString = range.getString(0)
    println(nativeString)
    require( nativeString.equals("99 from the shared library!"))
}

