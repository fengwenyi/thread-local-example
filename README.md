# 学习 ThreadLocal

## 并发接口示例

ab -n 20000 -c 500 http://localhost:8080/stat/add

curl http://localhost:8080/stat/get

![](./images/20200314172450.png)

一共发起20000次请求，500次并发，共耗时775ms