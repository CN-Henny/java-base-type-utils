### 功能型-Lambda表达式方式

入参全部采用Lambda表达式形式代入

#### List筛选-customToLambdaSelect()

##### customToLambdaSelect(匿名函数)

###### 入参

Lambda表达式形式

###### 返回值
List\<T> result

###### 实现功能
按传入字段进行筛选。支持与和或

###### 可能的异常
无

###### 使用示例
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
List<BigDecimal> result = u.customToLambdaSelect(e -> e.getUserName() == "1" && e.getSix() == "2");
```