# 如何查看log文件内容

Asmsupport采用log4j作为日志工具，配置直接采用log4j的配置。如果配置成debug模式则会输出下面的日志：

    DEBUG [main] create method: ------------main([Ljava/lang/String;)            //这里表示开始创建main(String[])方法
    DEBUG [main] call method by variable :out                                    //这里表示调用了out变量的方法
    DEBUG [main] put variable reference to stack                                 //既然要调用out变量的方法就需要将out变量的引用压入栈
    DEBUG [main] get field out from class java.lang.System and push to stack!    //通过这句话就能明白原来是调用我们最常见的System.out
    DEBUG [main] Instruction : GETSTATIC                                         //表执行JVM指令GETSTATIC(因为out是static类型的所以这里调用GETSTATIC指令获取out)
    DEBUG [main] Stack states                                                    //接下来这个图表表示的是栈的模型,上面GETSTATIC执行的结果就是返回一个静态field并且压入栈
    *********************************
    |         |Type                 |
    ********************************
    | ____    |Ljava/io/PrintStream;|
    |/ ___|   |                     |
    |\___ \   |                     |
    | ___) |  |                     |
    ||____/   |                     |
    *********************************
    .....
    DEBUG [main] store to local variable
    DEBUG [main] local variables states                //下面这个图表是本地变量的模型，通过图已经看出已经存放了两个本地变量，那他们分别表示什么呢
    ************************************************
    |         |Type                 |Name |Fragment|
    ************************************************
    | _       |[Ljava/lang/String;  |args |false   |   //[Ljava/lang/String;类型不就是上面方法的参数类型吗。没错，这里存放的就是我们方法的参数。
    || |      |Ljava/io/PrintStream;|myOut|false   |   //这里存放的就是上面栈中的out，是如何存的呢，继续往下看
    || |      |                     |     |        |
    || |___   |                     |     |        |
    ||_____|  |                     |     |        |
    |         |                     |     |        |
    ************************************************
    DEBUG [main] Instruction : ASTORE                  //找到了，就是这个指令ASTORE。它就是负责把栈顶元素弹出在然后存到本地变量的。
    DEBUG [main] Stack states                          //往下看 发现栈里面没东西了吧，让ASTORE给拿到local variables里去了
    ****************
    |         |Type|
    ****************
    | ____    |    |
    |/ ___|   |    |
    |\___ \   |    |
    | ___) |  |    |
    ||____/   |    |
    ****************
    .....
    DEBUG [main] Method : main([Ljava/lang/String;) Maxs(stack:1 locals:2) //这里值分配给栈和本地变量的最大值，通过上面的图就能看到栈和本地变量的最大值是多少了。
    
当然，这些log是需要你对jvm字节码有一定了解的才能看明白。这个给个网址可以参照：<a href="../jvmref/opcodes.html">Bytecode Reference.</a>