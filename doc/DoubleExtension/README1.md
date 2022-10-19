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