# java-base-type-utils包简介

## 代码改变世界，开源推动社区

## java-base-type-utils

出色的扩展函数类库，旨在对开发人员友好。

## 概述

- 全部基础类型的扩展
- 部分特殊类型的扩展
- 更多的utils帮助方法
- 支持Json处理
- 更完善的异常提示
- 简单化的调用
- 开发者友好

## 组织结构

```
java-base-type-utils
├── com -- 工具类及通用代码
├──── dlanqi.utils -- 工具类
├──── Interface -- 部分函数式接口
├── extensions -- 扩展函数主包
├──── java.lang -- 基础函数包
├──── java.io.File -- 文件类型函数包
├──── java.util -- list等特殊相关函数包
├──── java.Array -- 数组相关函数包
```

## 引入方式
- POM文件引入
- buid部分加入
```
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.0</version>
                <configuration>
                    <source>8</source>
                    <target>8</target>
                    <encoding>UTF-8</encoding>
                    <compilerArgs>
                        <!-- Configure manifold plugin-->
                        <arg>-Xplugin:Manifold</arg>
                    </compilerArgs>
                    <!-- Add the processor path for the plugin -->
                    <annotationProcessorPaths>
                        <path>
                            <groupId>systems.manifold</groupId>
                            <artifactId>manifold-ext</artifactId>
                            <version>2022.1.19</version>
                        </path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                            <version>1.18.16</version>
                        </path>
                    </annotationProcessorPaths>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

## 使用方法
定义想要的变量。然后直接链式调用
eg：
```
String a;
a.customIsNull();
```

## 方法描述

[DoubleExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/DoubleExtension/README.md)

[FloatExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/FloatExtension/README.md)

[IntegerExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/IntegerExtension/README.md)

[LongExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/LongExtension/README.md)

[ObjectExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/ObjectExtension/README.md)

[ShortExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/ShortExtension/README.md)

[StringExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/StringExtension/README.md)

[BooleanExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/BooleanExtension/README.md)

[ByteExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/ByteExtension/README.md)

[CharacterExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/CharacterExtension/README.md)

[IterableExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/IterableExtension/README.md)

[BigDecimalExtension](https://github.com/CN-Henny/java-base-type-utils/blob/main/doc/BigDecimalExtension/README.md)


## GitHub
https://github.com/CN-Henny/java-base-type-utils
开源不易，如果您喜欢这个项目, 请给个星星⭐️。

## 贡献

您可以帮助交付更好的java-base-type-utils

## 贡献者

感谢您做出贡献！

***Henny***
***Rex***
***Denghao***

## License

© Henny, 2022~time.Now