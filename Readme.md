# RULES_KSP bug

Simple repro showing that rules_kotlin does not handle non-java deps, like rules_java does.

This works:
```bazelrc

java_binary(
    name = "JavaMain",
    main_class = "app.MainKt",
    jvm_flags = ["--enable-native-accessALL-UNNAMED"],
    runtime_deps = [
        "main-lib",
        "//:native-lib"
    ],
)
```

This fails bazel build

```bazelrc
kt_jvm_binary(
	name = "KotlinMain",
	main_class = "app.MainKt",
	jvm_flags = ["--enable-native-access=ALL-UNNAMED"],
	runtime_deps = [
	    "main-lib",
 	    "//:native-lib"
	],
)
```
Code as checked in has the native dependency removed from the kt_jvm_binary. Remove comment to see bazel error.