Service/DAO层方法命名规约
1) 获取单个对象的方法用get做前缀。
2) 获取多个对象的方法用list做前缀。
3) 获取统计值的方法用count做前缀。
4) 插入的方法用save(推荐)或insert做前缀。 
5) 删除的方法用remove(推荐)或delete做前缀。 
6) 修改的方法用update做前缀,根新方法一定要包含更新update_time属性。