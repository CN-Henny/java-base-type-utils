 转换型-Lambda表达式方式

入参全部采用Lambda表达式形式代入

# List提取字段(单个字段)并转换成BigDecimal-customToBigDecimalList()

## customToBigDecimalList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<BigDecimal> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<String> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<BigDecimal> result = eg.customToBigDecimalList(e->e.customToBigDecimal());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<BigDecimal> result = u.customToBigDecimalList(e->e.getUserName().customToBigDecimal());
```

# List提取字段(单个字段)并转换成Long-customToLongList()

## customToLongList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<Long> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<String> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<Long> result = eg.customToLongList(e->e.customToLong());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<Long> result = u.customToLongList(e->e.getUserName().customToLong());
```

# List提取字段(单个字段)并转换成String-customToStringList()

## customToStringList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<String> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<String> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<String> result = eg.customToStringList(e->e.customToString());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<String> result = u.customToStringList(e->e.getUserName().customToString());
```

# List提取字段(单个字段)并转换成Double-customToDoubleList()

## customToDoubleList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<Double> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<Double> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<Double> result = eg.customToDoubleList(e->e.customToDouble());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<Double> result = u.customToDoubleList(e->e.getUserName().customToDouble());
```

# List提取字段(单个字段)并转换成Float-customToFloatList()

## customToFloatList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<Float> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<Float> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<Float> result = eg.customToFloatList(e->e.customToFloat());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<Float> result = u.customToFloatList(e->e.getUserName().customToFloat());
```

# List提取字段(单个字段)并转换成Integer-customToIntegerList()

## customToIntegerList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<Integer> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<Integer> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<Integer> result = eg.customToIntegerList(e->e.customToInteger());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<Integer> result = u.customToIntegerList(e->e.getUserName().customToInteger());
```

# List提取字段(单个字段)并转换成Date-customToDateList()

## customToDateList(匿名函数)

### 入参

Lambda表达式形式

### 返回值
List\<Date> result

### 实现功能
List提取字段(单个字段)并转换成List

### 可能的异常
无

### 使用示例
1. 基础类型转换
```
List<Date> eg = new ArrayList<>();
eg.customAdd("1").customAdd("4").customAdd("3");
List<Date> result = eg.customToDateList(e->e.customToDate());
```
2. T类型提取并转换
```
List<UserData> u = new ArrayList<>();
UserData u1 = new UserData();
u1.setUserName("1");
u1.setSix("1");
u.add(u1);
UserData u2 = new UserData();
u2.setUserName("1");
u2.setSix("1");
u.add(u2);
List<Date> result = u.customToDateList(e->e.getUserName().customToDate());
```