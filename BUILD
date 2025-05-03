load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library", "kt_jvm_binary")
load("@rules_kotlin//kotlin:core.bzl", "define_kt_toolchain")

define_kt_toolchain(
    name = "ktools",
    api_version = "2.1",
    jvm_target = "21",
    language_version = "2.1"
)

kt_jvm_library(
	name = "main-lib",
	srcs = ["src/kotlin/Main.kt"],
)

cc_binary(
    name = "native-lib",
    srcs = ["src/C++/lib.cpp"],
    linkshared = True,
    visibility = ["//visibility:public"],
)

java_binary(
	name = "JavaMain",
	main_class = "app.MainKt",
	jvm_flags = ["--enable-native-access=ALL-UNNAMED"],
	runtime_deps = [
	    "main-lib",
	    "//:native-lib"
	],
)

kt_jvm_binary(
	name = "KotlinMain",
	main_class = "app.MainKt",
	jvm_flags = ["--enable-native-access=ALL-UNNAMED"],
	runtime_deps = [
	    "main-lib",
# 	    This is the bug: Un-comment this line and the build will fail
# 	    "//:native-lib"
	],
)


