ROCKSDB-SERVER服务 - github


1、单独kv存储
/rocksdb/kv（Post）

参数：
table  string  表名
key    string  
value  string  


2、批量存储
/rocksdb/kvs（Post）

参数：
table   string          表名
keys    List<string>    例如：1,2,3
values  List<string>    例如：4,5,6


3、删除
/rocksdb/k/del（Post）

参数：
table string  表名
key   string  


4、批量删除
/rocksdb/ks/del（Post）

参数：
table   string          表名
keys    List<string>    例如：4,5,6


5、查询key
/rocksdb/kv（Get）

参数（根据type的类型，返回不同的对象，默认返回的value为string的格式）：
table string  表名  
key   string  
type  string  string\map\list


6、批量查询keys
/rocksdb/kvs（Get）

参数：
table   string          表名
keys    List<string>    例如：4,5,6


7、查询表的数量
/rocksdb/count（Get）

参数：
table  string  表名


8、查询表的100个kv数据
/rocksdb/hundred/kvs（Get）

参数：
table  string  表名


9、查询所有的表
/rocksdb/tables（Get）