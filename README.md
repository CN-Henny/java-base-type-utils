 java-base-type-utils

给java的基础类型提供了扩展函数

# 使用方法
定义想要的变量。然后直接链式调用
eg：
```
String a;
a.customIsNull();
```

# 方法描述

## DoubleExtension

Double类型扩展函数

### 判断型

#### 是否为空-customIsNull()

##### customIsNotNull()

###### 入参

无

###### 返回值
Boolean result
如果为空返回true
如果不为空返回false

###### 实现功能
判断一个Double是否为null

###### 可能的异常
无

#### 是否不为空-customIsNotNull()

##### customIsNotNull(Double  source)

###### 入参

无

###### 返回值
Boolean result
如果不为空返回true
如果为空返回false

###### 实现功能
判断一个Double是否为null

###### 可能的异常
无

##### customIsNotNull(Double errorBack)

###### 入参

1. Double  errorBack    自定义返回值

###### 返回值
Double result
如果不为空返回source 
如果为空返回errorBack 

###### 实现功能
判断一个Double是否为null并返回Double或自定义

###### 可能的异常
如果出现异常则返回errorBack

#### 是否为0-customIsZero()

##### customIsZero()

###### 入参

无

###### 返回值
Boolean result
如果为0返回true 
如果不为0返回false 

###### 实现功能
判断一个Double是否为0

###### 可能的异常
无

#### 是否不为0-customIsNotZero()

##### customIsNotZero()

###### 入参

无

###### 返回值
Boolean result
如果为0返回true 
如果不为0返回false 

###### 实现功能
判断一个Double是否为0

###### 可能的异常
无

##### customIsNotNull(Double errorBack)

###### 入参

1. Double  errorBack    自定义返回值

###### 返回值
Double result
如果不为0返回source 
如果为0返回errorBack 

###### 实现功能
判断一个Double是否为null并返回Double或自定义

###### 可能的异常
如果出现异常则返回errorBack

#### 判断正负数-customIsSign()

##### customIsSign()

###### 入参

无

###### 返回值
Integer result
如果 source大于0则返回1
如果 source等于0则返回0
如果 source小于0则返回-1

###### 实现功能
判断一个Double是正数还是负数还是0

###### 可能的异常
无

### 功能型

#### 比较是否相等-customEqual()

##### customEqual(Double condition)

###### 入参

1. Double condition       和之相比较的数

###### 返回值
Booleanresult
如果 source等于condition则返回true
如果 source不等于condition则返回false

###### 实现功能
比较亮哥数是否相等

###### 可能的异常
无

##### customEqual(Double condition, Boolean errorBack)

###### 入参

1. Double condition       和之相比较的数
2. Boolean errorBack    自定义返回值

###### 返回值
Boolean result
如果 source等于condition则返回true
如果 source不等于condition则返回false

###### 实现功能
比较两个数是否相等

###### 可能的异常
如果出现异常则返回errorBack

#### 比较大小-customCompareTo()

##### customCompareTo(Double condition)

###### 入参

1. Double condition       和之相比较的数

###### 返回值
Boolean result
如果 source大于condition则返回1
如果 source等于condition则返回0
如果 source小于condition则返回-1

###### 实现功能
两个数比较大小

###### 可能的异常
无

##### customCompareTo(Double condition, Boolean errorBack)

###### 入参

==1. Double condition       和之相比较的数
2. Boolean errorBack    自定义返回值 #ff0000==

###### 返回值
Boolean result
如果 source大于condition则返回1
如果 source等于condition则返回0
如果 source小于condition则返回-1

###### 实现功能
两个数比较大小

###### 可能的异常
如果出现异常则返回errorBack

#### 取绝对值

#### 小数位长度

#### 小数位长度（传默认）

#### 整数位长度

#### 整数位长度（传默认）

#### 四舍五入-含5

#### 四舍五入-含5（传默认）

#### 四舍五入-不含5

#### 四舍五入-不含5（传默认）

#### 舍

#### 舍（传默认）

#### 入

#### 入（传默认）

#### 不使用科学计数法

### 转换型

#### 转Byte

#### 转Float

#### 转Integer

#### 转Long

#### 转Short

#### 转String

#### 转BigDecimal

#### 转Byte（传默认）

#### 转Float（传默认）

#### 转Integer（传默认）

#### 转Long（传默认）

#### 转Short（传默认）

#### 转String（传默认）

#### 转BigDecimal（传默认）


# 微信请联系   _Hennys


