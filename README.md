# Demo JDK 23 Preview features on Quarkus

Toying around with JDK 23 preview features.
It works fine in unit-/quarkus-tests and dev-mode (even after a hot reload).
But when running the integration tests, if fails after ~1min, throwing:

```
Exception in thread "main" java.lang.reflect.InvocationTargetException
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:118)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at io.quarkus.bootstrap.runner.QuarkusEntryPoint.doRun(QuarkusEntryPoint.java:62)
	at io.quarkus.bootstrap.runner.QuarkusEntryPoint.main(QuarkusEntryPoint.java:33)
Caused by: java.lang.ExceptionInInitializerError
	at java.base/jdk.internal.misc.Unsafe.ensureClassInitialized0(Native Method)
	at java.base/jdk.internal.misc.Unsafe.ensureClassInitialized(Unsafe.java:1161)
	at java.base/jdk.internal.reflect.MethodHandleAccessorFactory.ensureClassInitialized(MethodHandleAccessorFactory.java:340)
	at java.base/jdk.internal.reflect.MethodHandleAccessorFactory.newConstructorAccessor(MethodHandleAccessorFactory.java:103)
	at java.base/jdk.internal.reflect.ReflectionFactory.newConstructorAccessor(ReflectionFactory.java:173)
	at java.base/java.lang.reflect.Constructor.acquireConstructorAccessor(Constructor.java:548)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:498)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:485)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:70)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:44)
	at io.quarkus.runtime.Quarkus.run(Quarkus.java:124)
	at io.quarkus.runner.GeneratedMain.main(Unknown Source)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	... 3 more
Caused by: java.lang.RuntimeException: Failed to start quarkus
	at io.quarkus.runner.ApplicationImpl.<clinit>(Unknown Source)
	... 16 more
Caused by: java.lang.UnsupportedClassVersionError: Preview features are not enabled for com/github/t1/Hellos (class file version 67.65535). Try running with '--enable-preview'
	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1026)
	at io.quarkus.bootstrap.runner.RunnerClassLoader.defineClass(RunnerClassLoader.java:152)
	at io.quarkus.bootstrap.runner.RunnerClassLoader.loadClass(RunnerClassLoader.java:111)
	at io.quarkus.bootstrap.runner.RunnerClassLoader.loadClass(RunnerClassLoader.java:72)
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:578)
	at java.base/java.lang.Class.forName(Class.java:557)
	at com.github.t1.Hellos_Bean.<init>(Unknown Source)
	at io.quarkus.arc.setup.Default_ComponentsProvider.addBeans1(Unknown Source)
	at io.quarkus.arc.setup.Default_ComponentsProvider.getComponents(Unknown Source)
	at io.quarkus.arc.impl.ArcContainerImpl.<init>(ArcContainerImpl.java:128)
	at io.quarkus.arc.Arc.initialize(Arc.java:38)
	at io.quarkus.arc.runtime.ArcRecorder.initContainer(ArcRecorder.java:49)
	at io.quarkus.deployment.steps.ArcProcessor$initializeContainer1770303700.deploy_0(Unknown Source)
	at io.quarkus.deployment.steps.ArcProcessor$initializeContainer1770303700.deploy(Unknown Source)
	... 17 more
```

See [Quarkus issue#10472](https://github.com/quarkusio/quarkus/issues/10472)
